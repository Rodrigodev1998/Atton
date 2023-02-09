package com.attornatus.enderecos.application.service;

import com.attornatus.enderecos.application.api.EnderecoDTO;
import com.attornatus.enderecos.application.api.EnderecoRequest;
import com.attornatus.enderecos.domain.Endereco;
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
public class EnderecoApplicationService implements EnderecoService {

    private final PessoaRepository pessoaRepository;

    public void adicionarEndereco(UUID idPessoa, EnderecoRequest enderecoRequest){
        log.info("[inicia] EnderecoApplicationService - adicionarEndereco");
        Pessoa pessoa = pessoaRepository.buscarPessoaPorId(idPessoa);
        pessoa.adicionarEndereco(enderecoRequest);
        pessoaRepository.salvarPessoa(pessoa);
        log.info("[finaliza] EnderecoApplicationService - adicionarEndereco");
    }

    @Override
    public List<EnderecoDTO> buscarEnderecosDePessoas(UUID idPessoa) {
        log.info("[inicia] EnderecoApplicationService - buscarEnderecosDePessoas");
        Pessoa pessoa = pessoaRepository.buscarPessoaPorId(idPessoa);
        List<Endereco> enderecos = pessoa.getEnderecos();
        log.info("[finaliza] EnderecoApplicationService - buscarEnderecosDePessoas");
        return EnderecoDTO.converte(enderecos);
    }

    @Override
    public EnderecoDTO buscarEnderecoPrincipal(UUID idPessoa) {
        log.info("[inicia] EnderecoApplicationService - buscarEnderecosDePessoas");
        Pessoa pessoa = pessoaRepository.buscarPessoaPorId(idPessoa);
        Endereco endereco = pessoa.buscarEnderecoPrincipal();
        log.info("[finaliza] EnderecoApplicationService - buscarEnderecosDePessoas");
        return new EnderecoDTO(endereco);
    }
}
