package br.com.letscode.saudedequalidade.PacienteTests;

import br.com.letscode.saudedequalidade.Paciente.PacienteService;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest
@SpringBootTest
public class PacienteControllerTests {

    @MockBean
    private PacienteService service;

}