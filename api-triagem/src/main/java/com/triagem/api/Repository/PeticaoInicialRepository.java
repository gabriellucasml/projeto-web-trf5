package com.triagem.api.Repository;

import com.triagem.api.Model.PeticaoInicial;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeticaoInicialRepository extends CrudRepository<PeticaoInicial, Long> {
    List<PeticaoInicial> findAll(Sort sort);
}
