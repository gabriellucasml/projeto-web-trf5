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
@Table(name = "stopwords")
@SQLDelete(sql = "UPDATE stopwords SET deleted = true, delete_date_time = NOW() WHERE palavra=?")
@FilterDef(name = "deletedStopwordsFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedStopwordsFilter", condition = "deleted = :isDeleted")
public class Stopwords {

    @Id
    @Column(name = "palavra", nullable = false, length = 9999)
    private String palavra;
    private Boolean deleted = Boolean.FALSE;
    private LocalDateTime deleteDateTime;

}
