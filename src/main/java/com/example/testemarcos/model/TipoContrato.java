package com.example.testemarcos.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class TipoContrato implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_type_of_contract")
    private Long pkTypeOfContract;

    private String designation;

    @OneToMany(mappedBy = "tipoContrato")
    private List<Contrato> contratoes;
}
