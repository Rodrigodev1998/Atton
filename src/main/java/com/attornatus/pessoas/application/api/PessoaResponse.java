package com.attornatus.pessoas.application.api;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Builder
@Data
public class PessoaResponse {

    private UUID idPessoa;
}
