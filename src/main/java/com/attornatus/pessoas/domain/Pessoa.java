package com.attornatus.pessoas.domain;


import com.attornatus.enderecos.application.api.EnderecoRequest;
import com.attornatus.enderecos.domain.Endereco;
import com.attornatus.enderecos.domain.TipoEndereco;
import com.attornatus.pessoas.application.api.PessoaAlteracao;
import com.attornatus.pessoas.application.api.PessoaRequest;
import com.attornatus.handler.APIException;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid")
    private UUID idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    public Pessoa(PessoaRequest pessoaRequest) {
        this.nome = pessoaRequest.getNome();
        this.dataNascimento = pessoaRequest.getDataNascimento();
        List<EnderecoRequest> enderecoRequest = pessoaRequest.getEnderecos();
        this.enderecos = enderecoRequest.stream()
                .map(endereco -> new Endereco(endereco))
                .collect(Collectors.toList());
    }

    public void alterar(PessoaAlteracao pessoaAlteracao) {
        this.nome = pessoaAlteracao.getNome();
        this.dataNascimento = pessoaAlteracao.getDataNascimento();
        this.enderecos = pessoaAlteracao.getEnderecos();
    }

    public void adicionarEndereco(EnderecoRequest enderecoRequest){
        enderecos.add(new Endereco(enderecoRequest));
    }

    public Endereco buscarEnderecoPrincipal(){
        return enderecos.stream()
                .filter(endereco -> endereco.getTipoEndereco().equals(TipoEndereco.PRINCIPAL))
                .findFirst()
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Endereço principal não encontrado"));
    }
}