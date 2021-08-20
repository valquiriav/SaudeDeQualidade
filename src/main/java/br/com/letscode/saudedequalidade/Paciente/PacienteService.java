package br.com.letscode.saudedequalidade.Paciente;

import br.com.letscode.saudedequalidade.Exceptions.PacienteNaoExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;



    public List<Paciente> getPacientes() {
        return repository.findAll();
    }

    public Paciente getPacienteByID(Long id) {
        return repository.findbyId(id).orElseThrow(PacienteNaoExistenteException::new);
    }

    public Paciente saveNewPaciente(Paciente novoPaciente) {
        return repository.save(novoPaciente);
    }
}
