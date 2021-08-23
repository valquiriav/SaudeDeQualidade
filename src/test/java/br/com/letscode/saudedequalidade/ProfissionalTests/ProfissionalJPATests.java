package br.com.letscode.saudedequalidade.ProfissionalTests;

import br.com.letscode.saudedequalidade.Profissional.Profissional;
import br.com.letscode.saudedequalidade.Profissional.ProfissionalRepository;
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
public class ProfissionalJPATests {

    @Autowired
    private ProfissionalRepository repository;

    public ProfissionalJPATests(){

    }

    @Test
    public void findAll(){
        Profissional profissional = new Profissional(12324525L,"bruno","augusto",
                "ortopedista", "Terça-Feira","sp");
        repository.save(profissional);
        List<Profissional> profissionalList = repository.findAll();
        assertFalse(profissionalList.isEmpty());
    }

    @Test
    public void testProfissionalListEmpty(){

        List<Profissional> profissionalList = repository.findAll();
        assertTrue(profissionalList.isEmpty());
    }

    @Test
    public void saveProfissional(){
        Profissional profissional = new Profissional(123456L,"Bruno","Augusto",
                "Ortopedista", "Segunda-Feira", "SP");
        repository.save(profissional);
        assertFalse(repository.findAll().isEmpty());
    }

    @Test
    public void testFindProfissionalByDisponibilidade(){
        Profissional profissional = new Profissional(123456L,"Bruno","Augusto",
                "Ortopedista", "Quarta-Feira", "SP");
        repository.save(profissional);
        List<Profissional> profissionalList= repository.findByDiaDisponivel("Quarta-Feira");
        assertFalse(profissionalList.isEmpty());
    }

    @Test
    public void testFindByEspecialidade(){
        Profissional profissional = new Profissional(123456L,"Bruno","Augusto",
                "Cardiologista", "Sexta-Feira", "SP");
        repository.save(profissional);
        assertFalse(repository.findByEspecialidade("Cardiologista").isEmpty());
    }
}
