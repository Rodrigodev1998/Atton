package com.attornatus.pessoas.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/pessoas")
public interface PessoaAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PessoaResponse adicionarPessoa(@RequestBody @Valid PessoaRequest pessoaRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ListPessoas> buscarTodasPessoas();

    @GetMapping(value = "/{idPessoa}")
    @ResponseStatus(code = HttpStatus.OK)
    PessoaDTO buscarPessoaPorId(@PathVariable UUID idPessoa);

    @PatchMapping(value = "/{idPessoa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alterarPessoa(@PathVariable UUID idPessoa, @RequestBody PessoaAlteracao pessoaAlteracao);
}
