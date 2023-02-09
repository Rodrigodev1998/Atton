package com.attornatus.pessoas.application.api;

import com.attornatus.enderecos.domain.Endereco;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PessoaAlteracao {

    private String nome;
    private LocalDate dataNascimento;
    private List<Endereco> enderecos;
}
