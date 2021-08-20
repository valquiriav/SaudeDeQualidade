package br.com.letscode.saudedequalidade.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}