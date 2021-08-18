package br.com.letscode.saudedequalidade.PacienteTests;

import br.com.letscode.saudedequalidade.Paciente.Paciente;
import br.com.letscode.saudedequalidade.Paciente.PacienteRepository;
import br.com.letscode.saudedequalidade.Profissional.Profissional;
import br.com.letscode.saudedequalidade.Profissional.ProfissionalRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PacienteJPATests {

    @Autowired
    private PacienteRepository repository;

    public PacienteJPATests(){

    }

    @Test
    void findAll(){
        Paciente paciente = new Paciente(321321L,"aline","pereira",
                "São Paulo", "01/02/2003");
        repository.save(paciente);
        List<Paciente> pacienteList = repository.findAll();
        assertFalse(pacienteList.isEmpty());
    }

    @Test
    void testPacienteListEmpty(){

        List<Paciente> pacienteList = repository.findAll();
        assertTrue(pacienteList.isEmpty());
    }

    @Test
    void savePaciente(){
        Paciente paciente = new Paciente(321321L,"aline","pereira",
                "São Paulo", "01/02/2003");
        repository.save(paciente);
        assertFalse(repository.findAll().isEmpty());
    }
}