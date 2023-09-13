package com.triagem.api.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "peticoes_iniciais")
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
}
