package com.attornatus.pessoas.application.api;

import com.attornatus.enderecos.domain.Endereco;
import com.attornatus.pessoas.domain.Pessoa;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class PessoaDTO {

    private UUID idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    private List<Endereco> enderecos;
    public PessoaDTO(Pessoa pessoa) {
        this.idPessoa = pessoa.getIdPessoa();
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
        this.enderecos = pessoa.getEnderecos();
    }
}
