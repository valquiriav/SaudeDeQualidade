package br.com.letscode.saudedequalidade.Paciente;

import br.com.letscode.saudedequalidade.Exceptions.PacienteNaoExistenteException;
import br.com.letscode.saudedequalidade.Profissional.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private PacienteRepository repository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        repository = pacienteRepository;
    }

    public List<Paciente> getPacientes() {
        return repository.findAll();
    }

    public Paciente getPacienteByID(Long id) {
        return repository.findByID(id).orElseThrow(PacienteNaoExistenteException::new);
    }

    public Paciente saveNewPaciente(Paciente novoPaciente) {
        return repository.save(novoPaciente);
    }
}
