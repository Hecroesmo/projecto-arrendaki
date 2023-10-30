package com.example.testemarcos.controller;

import com.example.testemarcos.model.Localidade;
import com.example.testemarcos.model.Pessoa;
import com.example.testemarcos.repository.LocalidadeRepository;
import com.example.testemarcos.repository.PessoaRepository;
import com.example.testemarcos.utility.LocalityUtility;
import com.example.testemarcos.utility.PersonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/persons")
public class PessoaController {
  @Autowired
  private PessoaRepository personRepo;

  @Autowired
  private LocalidadeRepository localityRepo;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Iterable<Pessoa> findAll() {
    return personRepo.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Pessoa save(@RequestBody Pessoa pessoa) {
    return personRepo.save(pessoa);
  }

  @PatchMapping("/{pkPerson}")
  @ResponseStatus(HttpStatus.CREATED)
  public Pessoa alter(@PathVariable long pkPerson, @RequestBody Pessoa newPessoa) {
    Pessoa pessoa = personRepo.findById(pkPerson).get();
    pessoa = PersonUtility.alterIfNotNull(pessoa, newPessoa);

    Localidade newLocalidade = new LocalityUtility()
        .alterIfNotNull(newPessoa.getFkLocalidade());

    if (newLocalidade == null) {
      pessoa.setFkLocalidade(newLocalidade);
    }
    return personRepo.save(pessoa);
  }

}
