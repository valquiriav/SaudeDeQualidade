package br.com.letscode.saudedequalidade.Consulta;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ConsultaRepository extends JpaRepository<Consulta, Long> {


    List<Consulta> findByIdPaciente(Long id);

    List<Consulta> findByIdProfissional(Long id);
}
