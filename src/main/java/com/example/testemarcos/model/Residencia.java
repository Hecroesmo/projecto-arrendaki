package com.example.testemarcos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
@ToString
@Entity
public class Residencia implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pk_house")
  private Long pkHouse;

  private String address;

  private double pricePerMonth;
  private String iban;

  @ManyToOne(optional = false, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
  @JoinColumn(name = "fk_owner")
  private Pessoa owner;

  @ManyToOne(optional = false, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
  @JoinColumn(name = "fk_locality")
  private Localidade localidade;

  @ManyToOne(optional = false, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
  @JoinColumn(name = "fk_typology")
  private Topologia topologia;

  @OneToMany(mappedBy = "residencia")
  private List<Foto> fotos;

  private boolean isFurnished; // Está mobiliada

  private boolean aprovado;

}
