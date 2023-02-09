package com.attornatus.pessoas.application.api;

import com.attornatus.enderecos.domain.Endereco;
import com.attornatus.pessoas.domain.Pessoa;
import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class ListPessoas {

    private UUID idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    private List<Endereco> enderecos;

    public static List<ListPessoas> converte(List<Pessoa> listPessoas) {
        return listPessoas.stream()
                .map(pessoa -> new ListPessoas(pessoa))
                .collect(Collectors.toList());
    }

    public ListPessoas(Pessoa listPessoas) {
        this.idPessoa = listPessoas.getIdPessoa();
        this.nome = listPessoas.getNome();
        this.dataNascimento = listPessoas.getDataNascimento();
        this.enderecos = listPessoas.getEnderecos();
    }
}
