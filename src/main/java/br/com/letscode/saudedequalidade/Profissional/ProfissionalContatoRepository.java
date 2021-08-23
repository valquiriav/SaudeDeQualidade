package br.com.letscode.saudedequalidade.Profissional;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfissionalContatoRepository extends JpaRepository<ProfissionalContato,Long> {

    List<ProfissionalContato> findProfissionalContatoByIdProfissional(Profissional profissional);
}
