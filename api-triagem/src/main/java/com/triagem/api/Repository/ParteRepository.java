package com.triagem.api.Repository;

import com.triagem.api.Model.Parte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParteRepository extends JpaRepository<Parte, Long> {

}
