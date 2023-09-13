package com.triagem.api.Controller;

import com.triagem.api.Model.ImagemID;
import com.triagem.api.Model.PeticaoInicial;
import com.triagem.api.Model.Processo;
import com.triagem.api.Service.PeticaoInicialService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/peticoes")
public class PeticaoInicialController {
    @Autowired
    PeticaoInicialService service;

    /**
     * POST METHOD
     */
    @PostMapping
    public PeticaoInicial inserir(@RequestBody PeticaoInicial peticaoInicial){
        return service.insert(peticaoInicial);
    }

    /**
     * GET METHOD
     */
    @GetMapping("/{id}")
    public PeticaoInicial pesquisarId(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<PeticaoInicial> listarTodos(){
        return service.findAll();
    }

    //(Example<S> example, Sort sort)
    /**
     * PUT METHOD
     */
    @PutMapping("/{id}/processo")
    public PeticaoInicial atualizarInfoProcesso(@PathVariable Long id, @RequestBody Processo processo){
        return service.atualizarInfos(id, processo);
    }

    @PutMapping("/{id}/imagem")
    public PeticaoInicial atualizarImagem(@PathVariable Long id, @RequestBody ImagemID idImagem){

        return service.atualizarNuvem(id, idImagem);
    }

    /**
     * DELETE METHOD
     */
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        service.delete(id);
    }


}

