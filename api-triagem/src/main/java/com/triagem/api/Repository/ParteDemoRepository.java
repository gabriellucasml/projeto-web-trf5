package com.triagem.api.Repository;

import com.triagem.api.Model.ParteDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParteDemoRepository extends JpaRepository<ParteDemo, Long> {

}
