package com.example.testemarcos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.testemarcos.model.TipoConta;
import com.example.testemarcos.repository.LocalidadeRepository;
import com.example.testemarcos.repository.TipoContaRepository;
import com.example.testemarcos.utility.TipoContaUtility;


@RestController
@RequestMapping("/tipo_conta")
@CrossOrigin(origins = "http://localhost:3000",allowedHeaders = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.PATCH})
public class TipoContaController {
  @Autowired
  private TipoContaRepository tipoContaRepository;

  @Autowired
  private LocalidadeRepository localityRepo;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Iterable<TipoConta> findAll() {
    return tipoContaRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TipoConta save(@RequestBody TipoConta tipoConta) {
    return tipoContaRepository.save(tipoConta);
  }

  @PatchMapping("/{pkTipoConta}")
  @ResponseStatus(HttpStatus.CREATED)
  public TipoConta alter(@PathVariable long pkTipoConta, @RequestBody TipoConta novo) {
    TipoConta tipoConta = tipoContaRepository.findById(pkTipoConta).get();
    tipoConta = TipoContaUtility.alterIfNotNull(tipoConta, novo);
    return tipoContaRepository.save(tipoConta);
  }

}
