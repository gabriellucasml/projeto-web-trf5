package com.triagem.api.Service;

import com.triagem.api.Model.Imagem;
import com.triagem.api.Model.Parte;
import com.triagem.api.Repository.ParteRepository;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class ParteService {
    ParteRepository repository;

    @Autowired
    private EntityManager entityManager;

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

    public List<Parte> findAll(boolean isDeleted){
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedParteFilter");
        filter.setParameter("isDeleted", isDeleted);
        List<Parte> parte = repository.findAll();
        session.disableFilter("deletedParteFilter");
        return parte;
    }
    //Atualizar
    // TODO
    //Remover
    public void delete(Long id){
        repository.deleteById(id);
    }
}
