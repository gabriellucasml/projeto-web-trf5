package com.triagem.api.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "partes")
public class Parte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String nome;
    private String cpf_cnpj;

    //Relacionamentos
    @OneToMany(mappedBy = "primaryKey.parte", cascade = CascadeType.ALL)
    private Set<ProcessoHasParte> processos;
}
