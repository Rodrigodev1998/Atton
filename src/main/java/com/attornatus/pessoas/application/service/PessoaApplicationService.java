package com.attornatus.pessoas.application.service;

import com.attornatus.pessoas.application.api.*;
import com.attornatus.pessoas.application.repository.PessoaRepository;
import com.attornatus.pessoas.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService {

    private final PessoaRepository pessoaRepository;
    @Override
    public PessoaResponse adicionarPessoa(PessoaRequest pessoaRequest) {
        log.info("[inicia] PessoaApplicationService - adicionarPessoa");
        Pessoa pessoa = pessoaRepository.salvarPessoa(new Pessoa(pessoaRequest));
        log.info("[finaliza] PessoaApplicationService - adicionarPessoa");
        return PessoaResponse.builder()
                .idPessoa(pessoa.getIdPessoa())
                .build();
    }

    @Override
    public List<ListPessoas> buscarTodasPessoas() {
        log.info("[inicia] PessoaApplicationService - buscarTodasPessoas");
        List<Pessoa> listPessoas = pessoaRepository.buscarTodasPessoas();
        log.info("[finaliza] PessoaApplicationService - buscarTodasPessoas");
        return ListPessoas.converte(listPessoas);
    }

    @Override
    public PessoaDTO buscarPessoaPorId(UUID idPessoa) {
        log.info("[inicia] PessoaApplicationService - buscarPessoaPorId");
        Pessoa pessoa = pessoaRepository.buscarPessoaPorId(idPessoa);
        log.info("[finaliza] PessoaApplicationService - buscarPessoaPorId");
        return new PessoaDTO(pessoa);
    }

    @Override
    public void alterarPessoa(PessoaAlteracao pessoaAlteracao, UUID idPessoa) {
        log.info("[inicia] PessoaApplicationService - alterarPessoa");
        Pessoa pessoa = pessoaRepository.buscarPessoaPorId(idPessoa);
        pessoa.alterar(pessoaAlteracao);
        pessoaRepository.salvarPessoa(pessoa);
        log.info("[finaliza] PessoaApplicationService - alterarPessoa");
    }
}
