package com.triagem.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.triagem.api.Model.Credenciais;

import java.util.Optional;

public interface CredenciaisRepository extends JpaRepository<Credenciais, String> {

    Optional<Credenciais> findByUsername(String username);
}