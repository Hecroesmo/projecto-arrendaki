package com.example.testemarcos.utility;


import com.example.testemarcos.model.TipoContrato;

public class TipoContratoUtility {
  public static TipoContrato alterIfNotNull(TipoContrato tipoContrato, TipoContrato novo) {
    if (novo.getDesignation() != null) {
      tipoContrato.setDesignation(novo.getDesignation());
    }

    if (novo.getContratoes() != null) {
      tipoContrato.setContratoes(novo.getContratoes());
    }
    return tipoContrato;
  }
}