package com.triagem.api.Service;

import com.triagem.api.Model.ParteDemo;
import com.triagem.api.Repository.ParteDemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParteDemoService {

    ParteDemoRepository repository;

    public ParteDemoService(ParteDemoRepository repository){
        this.repository = repository;
    }

    //Insert
    public ParteDemo insert(ParteDemo pd){
        return repository.save(pd);
    }

    //ListAll
    public List<ParteDemo> findAll(){
        return repository.findAll();
    }

    //FindById
    public Optional<ParteDemo> findById(Long id){
        return repository.findById(id);
    }

    //Update
    public ParteDemo update(ParteDemo pd){
        return repository.saveAndFlush(pd);
    }

    //Delete
    public void delete(Long id){
        repository.deleteById(id);
    }
}
