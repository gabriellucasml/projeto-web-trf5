package com.triagem.api.Model;

import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "partes")
@SQLDelete(sql = "UPDATE partes SET deleted = true, delete_date_time = NOW() WHERE id=?")
@FilterDef(name = "deletedParteFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedParteFilter", condition = "deleted = :isDeleted")
public class Parte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String nome;
    private String cpf_cnpj;
    private Boolean deleted = Boolean.FALSE;
    private LocalDateTime deleteDateTime;

    //Relacionamentos
    @OneToMany(mappedBy = "primaryKey.parte", cascade = CascadeType.ALL)
    private Set<ProcessoHasParte> processos;
}
