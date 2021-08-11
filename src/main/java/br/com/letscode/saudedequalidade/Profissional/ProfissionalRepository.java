package br.com.letscode.saudedequalidade.Profissional;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    @Override
    Optional<Profissional> findById(Long aLong);

    Optional<Profissional> findByEspecialidade(String especialidade);
}
