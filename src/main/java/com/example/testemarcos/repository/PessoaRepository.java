package com.example.testemarcos.repository;

import com.example.testemarcos.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
  Pessoa findByIdentifyCardNumber(String identifyCardNumber);
}
