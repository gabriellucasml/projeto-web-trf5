package com.triagem.api.Service;

import com.triagem.api.Model.Parte;
import com.triagem.api.Repository.ParteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParteService {
    ParteRepository repository;
    public ParteService(ParteRepository repository){
        this.repository = repository;
    }
    //Adicionar
    public Parte insert(Parte parte){
        Parte result = repository.save(parte);
        return result;
    }
    //Consultar
    public Parte findById(Long id){
        Optional<Parte> parte = repository.findById(id);
        return parte.get();
    }

    public List<Parte> findAll(){
        return repository.findAll();
    }
    //Atualizar
    // TODO
    //Remover
    public void delete(Long id){
        repository.deleteById(id);
    }
}
