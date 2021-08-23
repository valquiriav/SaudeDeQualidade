package br.com.letscode.saudedequalidade.PacienteTests;

import br.com.letscode.saudedequalidade.Paciente.Paciente;
import br.com.letscode.saudedequalidade.Paciente.PacienteRepository;
import org.junit.Test;
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
    public void findAll(){
        Paciente paciente = new Paciente(321321L, "valquiria", "oliveira", "mg");
        repository.save(paciente);
        List<Paciente> pacienteList = repository.findAll();
        assertFalse(pacienteList.isEmpty());
    }

    @Test
    public void testPacienteListEmpty(){
        List<Paciente> pacienteList = repository.findAll();
        assertTrue(pacienteList.isEmpty());
    }

    @Test
    public void savePaciente(){
        Paciente paciente = new Paciente(321321L, "valquiria", "oliveira", "mg");
        repository.save(paciente);
        assertFalse(repository.findAll().isEmpty());
    }
}