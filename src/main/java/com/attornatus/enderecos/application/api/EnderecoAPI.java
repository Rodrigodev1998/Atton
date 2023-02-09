package com.attornatus.enderecos.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/pessoa/{idPessoa}/enderecos")
public interface EnderecoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    void adicionarEndereco(@PathVariable UUID idPessoa, @RequestBody EnderecoRequest enderecoRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<EnderecoDTO> buscarEnderecosDePessoa(@PathVariable UUID idPessoa);

    @GetMapping (value ="/enderecoprincipal")
    @ResponseStatus(code = HttpStatus.OK)
    EnderecoDTO buscarEnderecoPrincipal(@PathVariable UUID idPessoa);
}
