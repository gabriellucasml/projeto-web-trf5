package com.triagem.api.Controller;


import com.triagem.api.Model.ParteDemo;
import com.triagem.api.Service.ParteDemoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partedemo")
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin(origins = "*")
public class ParteDemoController {
    @Autowired
    ParteDemoService service;

    @PostMapping
    public ResponseEntity<ParteDemo> insert(@RequestBody ParteDemo pd){
        return ResponseEntity.status(201).body(service.insert(pd));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ParteDemo> update(@RequestBody ParteDemo pd, @PathVariable Long id){
        return service
                .findById(id)
                .map(parteDemo -> {
                    service.update(pd);
                    return ResponseEntity.ok().body(pd);
            }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<ParteDemo> findAll(){
        return service.findAll(true);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ParteDemo> findById(@PathVariable Long id){
        var stopwords = service.findById(id);

        if(stopwords.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(stopwords.get());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service
                .findById(id)
                .map( pessoa -> {
                    service.delete(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
