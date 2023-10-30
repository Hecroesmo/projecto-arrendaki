package com.example.testemarcos.controller;

import com.example.testemarcos.model.Localidade;
import com.example.testemarcos.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/localities")
public class LocalidadeController {
  @Autowired
  LocalidadeRepository localityRepo;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Iterable<Localidade> findAll() {
    return localityRepo.findAll();
  }

  @GetMapping("/{pkLocality}")
  @ResponseStatus(HttpStatus.OK)
  public Localidade findById(@PathVariable long pkLocality) {
    return localityRepo.findById(pkLocality).get();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Localidade save(@RequestBody Localidade newLocalidade) {
    return localityRepo.save(newLocalidade);
  }

  @PatchMapping("/{pkLocality}")
  @ResponseStatus(HttpStatus.OK)
  public Localidade alter(@PathVariable long pkLocality, @RequestBody Localidade newLocalidade) {
    Localidade localidade = localityRepo.findById(pkLocality).get();
    localidade.setDesignation(newLocalidade.getDesignation());
    return localityRepo.save(localidade);
  }

  @DeleteMapping("/{pkLocality}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable long pkLocality) {
    System.err.println("pkLocality: " + pkLocality);
    localityRepo.deleteById(pkLocality);
  }

}
