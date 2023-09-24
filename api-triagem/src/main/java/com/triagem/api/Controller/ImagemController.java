package com.triagem.api.Controller;

import com.triagem.api.Model.Imagem;
import com.triagem.api.Model.ImagemResponse;
import com.triagem.api.Service.ImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("imagem")
public class ImagemController {

    @Autowired
    private ImagemService service;

    /**
     * POST METHOD
     */
    @PostMapping
    public ResponseEntity<String> inserir(@RequestParam("file") MultipartFile arquivo){
        try {
            String res = service.insert(arquivo);
            String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/imagem/")
                    .path(res)
                    .toUriString();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format(downloadURL));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(String.format("Problema ao salvar o arquivo: " + arquivo.getOriginalFilename()));
        }

    }

    /**
     * GET METHOD
     */
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> pesquisarId(@PathVariable String id){
        Optional<Imagem> arquivoOptional = service.findById(id);
        if (arquivoOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Imagem result = arquivoOptional.get();
            return ResponseEntity.ok().header(
                    HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + result.getNome() + "\"")
                    .contentType(MediaType.valueOf(result.getContentType()))
                    .body(result.getData());
        }
    }

    @GetMapping
    public List<ImagemResponse> listarTodos(){
        return service.findAll(true)
                .stream()
                .map(this::mapToFileResponse)
                .collect(Collectors.toList());
    }

    private ImagemResponse mapToFileResponse(Imagem imagem) {
        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/imagem/")
                .path(imagem.getId())
                .toUriString();
        ImagemResponse arquivoResponse = new ImagemResponse();
        arquivoResponse.setId(imagem.getId());
        arquivoResponse.setNome(imagem.getNome());
        arquivoResponse.setContentType(imagem.getContentType());
        arquivoResponse.setSize(imagem.getSize());
        arquivoResponse.setUrl(downloadURL);

        return arquivoResponse;
    }

    /**
     * DELETE METHOD
     */
    @DeleteMapping
    public void remover(String id){
        service.delete(id);
    }
}
