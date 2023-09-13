package com.triagem.api.Controller;

import com.triagem.api.Model.Processo;
import com.triagem.api.Model.Stopwords;
import com.triagem.api.Service.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processos")
@CrossOrigin(origins = "*")
public class ProcessoController {
    @Autowired
    ProcessoService service;

    /**
     * POST METHOD
     */
    @PostMapping
    public Processo inserir(@RequestBody Processo processo){
        return service.insert(processo);
    }

    /**
     * GET METHOD
     */
    @GetMapping("/{id}")
    public Processo pesquisarId(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Processo> listarTodos(){
        return service.findAll();
    }

    /**
     * DELETE METHOD
     */
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        service.delete(id);
    }
}