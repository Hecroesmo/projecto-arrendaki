package com.example.testemarcos.controller;

import com.example.testemarcos.model.Localidade;
import com.example.testemarcos.model.TipoConta;
import com.example.testemarcos.repository.LocalidadeRepository;
import com.example.testemarcos.repository.TipoContaRepository;
import com.example.testemarcos.utility.LocalityUtility;
import com.example.testemarcos.utility.PersonUtility;
import com.example.testemarcos.utility.TipoContaUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tipo_conta")
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
