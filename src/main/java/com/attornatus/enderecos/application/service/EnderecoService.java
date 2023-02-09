package com.attornatus.enderecos.application.service;

import com.attornatus.enderecos.application.api.EnderecoDTO;
import com.attornatus.enderecos.application.api.EnderecoRequest;

import java.util.List;
import java.util.UUID;

public interface EnderecoService {

    void adicionarEndereco(UUID idPessoa, EnderecoRequest enderecoRequest);

    List<EnderecoDTO> buscarEnderecosDePessoas(UUID idPessoa);

    EnderecoDTO buscarEnderecoPrincipal(UUID idPessoa);
}
