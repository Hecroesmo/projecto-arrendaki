package com.example.testemarcos.repository;

import com.example.testemarcos.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta,Long> {
    @Query("SELECT c FROM Conta c WHERE c.email = ?1")
    Optional<Conta> findByEmail(String email);
}
