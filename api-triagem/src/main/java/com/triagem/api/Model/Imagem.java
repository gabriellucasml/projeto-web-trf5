package com.triagem.api.Model;

import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE imagem SET deleted = true, delete_date_time = NOW() WHERE id=?")
@FilterDef(name = "deletedImagemFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedImagemFilter", condition = "deleted = :isDeleted")
public class Imagem {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String nome;
    private String contentType;
    private Long size;

    @Lob
    private byte[] data;
    private Boolean deleted = Boolean.FALSE;
    private LocalDateTime deleteDateTime;
}
