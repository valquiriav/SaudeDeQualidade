package br.com.letscode.saudedequalidade.Profissional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    @Override
    Optional<Profissional> findById(Long aLong);

    Optional<Profissional> findByEspecialidade(String especialidade);
}
