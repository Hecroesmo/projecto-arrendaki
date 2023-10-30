package com.example.testemarcos.utility;


import com.example.testemarcos.model.TipoConta;

public class TipoContaUtility {
  public static TipoConta alterIfNotNull(TipoConta tipoConta, TipoConta novo) {
    if (novo.getDesignation() != null) {
      tipoConta.setDesignation(novo.getDesignation());
    }

    if (novo.getContas() != null) {
      tipoConta.setContas(novo.getContas());
    }
    return tipoConta;
  }
}