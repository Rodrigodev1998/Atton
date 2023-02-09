package com.attornatus.enderecos.application.api;

import com.attornatus.enderecos.domain.Endereco;
import com.attornatus.enderecos.domain.TipoEndereco;
import lombok.Data;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class EnderecoDTO {

    private UUID idEndereco;
    private String logradouro;
    private int cep;
    private int numero;
    private String cidade;

    private TipoEndereco tipoEndereco = TipoEndereco.PRINCIPAL;

    public EnderecoDTO(Endereco endereco) {

        this.idEndereco = endereco.getIdEndereco();
        this.logradouro = endereco.getLogradouro();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.tipoEndereco = endereco.getTipoEndereco();

    }

    public static List<EnderecoDTO> converte(List<Endereco> enderecos) {
        return enderecos.stream()
                .map(endereco -> new EnderecoDTO(endereco))
                .collect(Collectors.toList());
    }
}