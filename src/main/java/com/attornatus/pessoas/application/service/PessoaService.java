package com.attornatus.pessoas.application.service;

import com.attornatus.pessoas.application.api.*;

import java.util.List;
import java.util.UUID;

public interface PessoaService {
    public PessoaResponse adicionarPessoa(PessoaRequest pessoaRequest);

    PessoaDTO buscarPessoaPorId(UUID idPessoa);

    List<ListPessoas> buscarTodasPessoas();

    void alterarPessoa(PessoaAlteracao pessoaAlteracao, UUID idPessoa);


}
