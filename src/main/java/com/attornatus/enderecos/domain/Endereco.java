package com.attornatus.enderecos.domain;

import com.attornatus.enderecos.application.api.EnderecoRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid")
    private UUID idEndereco;
    private String logradouro;
    private int cep;
    private int numero;
    private String cidade;
    private TipoEndereco tipoEndereco = TipoEndereco.PRINCIPAL;

    public Endereco(EnderecoRequest enderecoRequest) {
        this.logradouro = enderecoRequest.getLogradouro();
        this.cep = enderecoRequest.getCep();
        this.numero = enderecoRequest.getNumero();
        this.cidade = enderecoRequest.getCidade();
        this.tipoEndereco = enderecoRequest.getTipoEndereco();
    }
}