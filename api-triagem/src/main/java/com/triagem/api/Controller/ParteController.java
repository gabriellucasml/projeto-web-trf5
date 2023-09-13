package com.triagem.api.Controller;

import com.triagem.api.Model.Parte;
import com.triagem.api.Service.ParteService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partes")
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin(origins = "*")
public class ParteController {
    @Autowired
    ParteService service;

    /**
     * POST METHOD
     */
    @PostMapping
    public Parte inserir(@RequestBody Parte parte){
        return service.insert(parte);
    }

    /**
     * GET METHOD
     */
    @GetMapping("/{id}")
    public Parte pesquisarId(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Parte> listarTodos(){
        return service.findAll();
    }

    /**
     * DELETE METHOD
     */
    @DeleteMapping
    public void remover(Long id){
        service.delete(id);
    }
}