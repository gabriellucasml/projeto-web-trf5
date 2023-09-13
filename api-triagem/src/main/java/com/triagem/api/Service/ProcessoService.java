package com.triagem.api.Service;

import com.triagem.api.Model.Processo;
import com.triagem.api.Model.Stopwords;
import com.triagem.api.Repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessoService {
    @Autowired
    ProcessoRepository repository;

    //Insert
    public Processo insert(Processo processo){
        Processo result = repository.save(processo);
        return result;
    }

    //FindById
    public Processo findById(Long id){
        Optional<Processo> processo = repository.findById(id);
        return processo.get();
    }

    //FindAll
    public List<Processo> findAll(){
        return repository.findAll();
    }

    //Atualizar
    // TODO

    //Delete
    public void delete(Long id){
        repository.deleteById(id);
    }
}