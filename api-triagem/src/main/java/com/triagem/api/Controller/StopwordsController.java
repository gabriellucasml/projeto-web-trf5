package com.triagem.api.Controller;

import com.triagem.api.Model.Stopwords;
import com.triagem.api.Service.StopwordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/stopwords")
public class StopwordsController {

    @Autowired
    StopwordsService service;

    @PostMapping
    public ResponseEntity<Stopwords> insert(@RequestBody Stopwords s){
        return ResponseEntity.status(201).body(service.insert(s));
    }

    @PutMapping(path = "/{palavra}")
    public ResponseEntity<Stopwords> update(@RequestBody Stopwords s, @PathVariable String palavra){
        return service.findById(palavra).map(stopwords -> {
            service.update(s);
            return ResponseEntity.ok().body(s);
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Stopwords> findAll(){
        return service.findAll(true);
    }

    @GetMapping(path = "/{palavra}")
    public ResponseEntity<Stopwords> findById(@PathVariable String palavra){
        var stopwords = service.findById(palavra);

        if(stopwords.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(stopwords.get());
        }
    }

    @DeleteMapping(path = "/{palavra}")
    public ResponseEntity<?> delete(@PathVariable String palavra){
        return service
                .findById(palavra)
                .map( pessoa -> {
                    service.delete(palavra);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
