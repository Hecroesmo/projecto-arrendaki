package com.example.testemarcos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@Data
@ToString
@Entity
public class Foto implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pk_photo")
  private Long pkPhoto;

  private String fileName;

  @ManyToOne
  @JoinColumn(name = "fk_house")
  private Residencia residencia;
}
