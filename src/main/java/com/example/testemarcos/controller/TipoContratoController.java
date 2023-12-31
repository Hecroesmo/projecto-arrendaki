package com.example.testemarcos.controller;

import com.example.testemarcos.model.TipoContrato;
import com.example.testemarcos.repository.TipoContratoRepository;
import com.example.testemarcos.utility.TipoContratoUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tipo_contrato")
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.PATCH})
public class TipoContratoController {
  @Autowired
  private TipoContratoRepository tipoContratoRepository;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Iterable<TipoContrato> findAll() {
    return tipoContratoRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TipoContrato save(@RequestBody TipoContrato tipoContrato) {
    return tipoContratoRepository.save(tipoContrato);
  }

  @PatchMapping("/{pkTipoConta}")
  @ResponseStatus(HttpStatus.CREATED)
  public TipoContrato alter(@PathVariable long pkTipoConta, @RequestBody TipoContrato novo) {
    TipoContrato tipoContrato = tipoContratoRepository.findById(pkTipoConta).get();
    tipoContrato = TipoContratoUtility.alterIfNotNull(tipoContrato, novo);
    return tipoContratoRepository.save(tipoContrato);
  }

}
