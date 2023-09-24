package com.triagem.api.Service;

import com.triagem.api.Model.Parte;
import com.triagem.api.Model.ParteDemo;
import com.triagem.api.Repository.ParteDemoRepository;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class ParteDemoService {

    ParteDemoRepository repository;
    @Autowired
    EntityManager entityManager;

    public ParteDemoService(ParteDemoRepository repository){
        this.repository = repository;
    }

    //Insert
    public ParteDemo insert(ParteDemo pd){
        return repository.save(pd);
    }

    //ListAll
    public List<ParteDemo> findAll(boolean isDeleted){
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedParteDemoFilter");
        filter.setParameter("isDeleted", isDeleted);
        List<ParteDemo> parteDemos = repository.findAll();
        session.disableFilter("deletedParteDemoFilter");
        return parteDemos;
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
