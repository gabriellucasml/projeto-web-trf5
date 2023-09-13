package com.triagem.api.Repository;

import com.triagem.api.Model.ProcessoHasParte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoHasParteRepository extends JpaRepository<ProcessoHasParte, Long> {
}
