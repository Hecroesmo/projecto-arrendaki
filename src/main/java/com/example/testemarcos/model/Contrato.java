package com.example.testemarcos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contrato implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_contract")
    private Long pkContract;

    @ManyToOne
    @JoinColumn(name = "fk_client")
    private Conta client;

    @ManyToOne
    @JoinColumn(name = "fk_house")
    private Residencia residencia;

    @Temporal(TemporalType.DATE)
    private Date initialDate;

    @Temporal(TemporalType.DATE)
    private Date finalDate;

    @ManyToOne
    @JoinColumn(name = "fk_type_contract")
    private TipoContrato tipoContrato;
}
