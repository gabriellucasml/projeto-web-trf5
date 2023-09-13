package com.triagem.api.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProcessoParteId implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    private Processo processo;

    @ManyToOne(cascade = CascadeType.ALL)
    private Parte parte;
}
