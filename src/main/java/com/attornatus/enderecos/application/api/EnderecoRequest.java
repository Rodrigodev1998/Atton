package com.attornatus.enderecos.application.api;

import com.attornatus.enderecos.domain.TipoEndereco;
import lombok.Data;

@Data
public class EnderecoRequest {

    private String logradouro;
    private int cep;
    private int numero;
    private String cidade;
    private TipoEndereco tipoEndereco;
}
