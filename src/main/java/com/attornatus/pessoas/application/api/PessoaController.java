package com.attornatus.pessoas.application.api;

import com.attornatus.pessoas.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PessoaController implements PessoaAPI {

    private final PessoaService pessoaService;
    @Override
    public PessoaResponse adicionarPessoa(PessoaRequest pessoaRequest) {
        log.info("[inicia] PessoasController - adicionarPessoa");
        PessoaResponse pessoaResponse = pessoaService.adicionarPessoa(pessoaRequest);
        log.info("[finaliza] PessoasController - adicionarPessoa");
        return pessoaResponse;
    }

    @Override
    public List<ListPessoas> buscarTodasPessoas() {
        log.info("[inicia] PessoasController - buscarTodasPessoas");
        List<ListPessoas> pessoasList = pessoaService.buscarTodasPessoas();
        log.info("[finaliza] PessoasController - buscarTodasPessoas");
        return pessoasList;
    }

    @Override
    public PessoaDTO buscarPessoaPorId(UUID idPessoa) {
        log.info("[inicia] PessoasController - buscarPessoaPorId");
        PessoaDTO pessoa = pessoaService.buscarPessoaPorId(idPessoa);
        log.info("[finaliza] PessoasController - buscarPessoaPorId");
        return pessoa;

    }

    @Override
    public void alterarPessoa(UUID idPessoa, PessoaAlteracao pessoaAlteracao) {
        log.info("[inicia] PessoasController - alterarPessoa");
        pessoaService.alterarPessoa(pessoaAlteracao, idPessoa);
        log.info("[finaliza] PessoasController - alterarPessoa");
    }
}
