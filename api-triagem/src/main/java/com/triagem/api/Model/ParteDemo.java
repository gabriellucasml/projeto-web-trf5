package com.triagem.api.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "partedemo")
@SQLDelete(sql = "UPDATE partedemo SET deleted = true, delete_date_time = NOW() WHERE id=?")
@FilterDef(name = "deletedParteDemoFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedParteDemoFilter", condition = "deleted = :isDeleted")
public class ParteDemo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String cpf_cnpj;

    @Column(nullable = false)
    private Boolean polo;
    private Boolean deleted = Boolean.FALSE;
    private LocalDateTime deleteDateTime;
}
