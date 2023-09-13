package com.triagem.api.Model;

import com.triagem.api.Model.enuns.TipoParte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AssociationOverrides({
        @AssociationOverride(
                name = "primaryKey.processo",
                joinColumns = @JoinColumn(
                        name = "processo_id"
                )
        ),
        @AssociationOverride(
                name = "primaryKey.parte",
                joinColumns = @JoinColumn(
                        name = "parte_id"
                )
        )
})
public class ProcessoHasParte {
    @EmbeddedId
    private ProcessoParteId primaryKey = new ProcessoParteId();

    @Transient
    private Processo processo;
    @Transient
    private Parte parte;
    //campos adicionais
    private TipoParte tipo;


}
