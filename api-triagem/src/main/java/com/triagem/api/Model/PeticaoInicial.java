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
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "peticoes_iniciais")
@SQLDelete(sql = "UPDATE peticoes_iniciais SET deleted = true, delete_date_time = NOW() WHERE id=?")
@FilterDef(name = "deletedPeticaoInicialFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedPeticaoInicialFilter", condition = "deleted = :isDeleted")
public class PeticaoInicial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String textoPeticao;

    private String assunto;

    //Apenas para salvar a parte encontrada...deve ser ajustado no projeto definitivo
    private String parte1Aux;

    //Apenas para salvar a parte encontrada...deve ser ajustado no projeto definitivo
    private String parte2Aux;


    //Relacionamentos
    @OneToOne
    @JoinColumn(name = "id_processo")
    private Processo processo;

    private String nuvem;

    private String doc_origem;

    private Boolean deleted = Boolean.FALSE;
    private LocalDateTime deleteDateTime;
}
