package com.example.testemarcos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Data
@ToString
@Entity
public class Pessoa implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pk_person")
  private Long pkPerson;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "identify_card_number")
  private String identifyCardNumber;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "birth_date")
  private Date birthDate;

  @ManyToOne(optional = false, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
  @JoinColumn(name = "fk_locality")
  private Localidade fkLocalidade;

  @OneToOne(mappedBy = "pessoa")
  private Conta conta;

}
