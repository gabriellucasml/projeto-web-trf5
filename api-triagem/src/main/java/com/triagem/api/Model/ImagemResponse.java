package com.triagem.api.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImagemResponse {
    private String id;
    private String nome;
    private Long size;
    private String url;
    private String contentType;
}
