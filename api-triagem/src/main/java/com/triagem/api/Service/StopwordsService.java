package com.triagem.api.Service;

import com.triagem.api.Model.Parte;
import com.triagem.api.Model.Stopwords;
import com.triagem.api.Repository.StopwordsRepository;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class StopwordsService {

    StopwordsRepository repository;
    @Autowired
    EntityManager entityManager;

    public StopwordsService(StopwordsRepository repository){
        this.repository = repository;
    }

    //Insert
    public Stopwords insert(Stopwords s){
        return repository.save(s);
    }

    //ListAll
    public List<Stopwords> findAll(boolean isDeleted){
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedStopwordsFilter");
        filter.setParameter("isDeleted", isDeleted);
        List<Stopwords> stopwords = repository.findAll();
        session.disableFilter("deletedParteFilter");
        return stopwords;
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
