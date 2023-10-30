package com.example.testemarcos.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class TipoConta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_type_of_account")
    private Long pkTypeOfAccount;

    private String designation;

    @OneToMany(mappedBy = "tipoConta")
    private List<Conta> contas;


}
