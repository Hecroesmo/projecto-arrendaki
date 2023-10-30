package com.example.testemarcos.utility;


import com.example.testemarcos.model.Localidade;
import com.example.testemarcos.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LocalityUtility {
  @Autowired
  private LocalidadeRepository repo;

  public Localidade alterIfNotNull(Localidade localidade) {
    long pkLocality = localidade.getPkLocality();
    if (pkLocality <= 0) {
      return null;
    }

    Localidade newLocalidade = repo.findById(pkLocality).get();
    return newLocalidade;
  }
}
