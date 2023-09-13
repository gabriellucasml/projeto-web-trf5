package com.triagem.api.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "processos")
public class Processo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float valorCausa;
    private Boolean justGratuita;
    private Boolean pedidoLiminar;
    private Boolean pedidoTutelar;


    //Relacionamentos
    @OneToMany(mappedBy = "primaryKey.processo", cascade = CascadeType.ALL)
    private Set<ProcessoHasParte> partes;
}
