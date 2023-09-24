package com.triagem.api.Model;

import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "processos")
@SQLDelete(sql = "UPDATE processos SET deleted = true, delete_date_time = NOW() WHERE id=?")
@FilterDef(name = "deletedProcessosFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedProcessosFilter", condition = "deleted = :isDeleted")
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

    private Boolean deleted = Boolean.FALSE;
    private LocalDateTime deleteDateTime;
}
