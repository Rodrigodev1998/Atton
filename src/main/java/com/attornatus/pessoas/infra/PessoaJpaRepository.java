package com.attornatus.pessoas.infra;

import com.attornatus.pessoas.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaJpaRepository extends JpaRepository<Pessoa, UUID> {
}
