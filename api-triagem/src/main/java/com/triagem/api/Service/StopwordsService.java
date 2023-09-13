package com.triagem.api.Service;

import com.triagem.api.Model.Stopwords;
import com.triagem.api.Repository.StopwordsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StopwordsService {

    StopwordsRepository repository;

    public StopwordsService(StopwordsRepository repository){
        this.repository = repository;
    }

    //Insert
    public Stopwords insert(Stopwords s){
        return repository.save(s);
    }

    //ListAll
    public List<Stopwords> findAll(){
        return repository.findAll();
    }

    //FindById
    public Optional<Stopwords> findById(String palavra){
        return repository.findById(palavra);
    }

    //Update
    public Stopwords update(Stopwords s){
        return repository.saveAndFlush(s);
    }

    //Delete
    public void delete(String palavra){
        repository.deleteById(palavra);
    }

}
