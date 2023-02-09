package com.attornatus.pessoas.application.repository;

import com.attornatus.pessoas.domain.Pessoa;

import java.util.List;
import java.util.UUID;

public interface PessoaRepository {
    Pessoa salvarPessoa(Pessoa pessoa);

    Pessoa buscarPessoaPorId(UUID idPessoa);

    List<Pessoa> buscarTodasPessoas();
}
