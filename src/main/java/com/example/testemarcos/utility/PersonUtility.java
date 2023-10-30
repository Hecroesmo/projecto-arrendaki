package com.example.testemarcos.utility;


import com.example.testemarcos.model.Pessoa;

public class PersonUtility {
  public static Pessoa alterIfNotNull(Pessoa pessoa, Pessoa newPessoa) {
    if (newPessoa.getBirthDate() != null) {
      pessoa.setBirthDate(newPessoa.getBirthDate());
    }

    if (newPessoa.getFullName() != null) {
      pessoa.setFullName(newPessoa.getFullName());
    }

    if (newPessoa.getPhoneNumber() != null) {
      pessoa.setPhoneNumber(newPessoa.getPhoneNumber());
    }

    if (newPessoa.getIdentifyCardNumber() != null) {
      pessoa.setIdentifyCardNumber(newPessoa.getIdentifyCardNumber());
    }

    return pessoa;
  }
}