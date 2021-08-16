package br.com.letscode.saudedequalidade.ProfissionalTests;

import br.com.letscode.saudedequalidade.Profissional.ProfissionalService;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest
@SpringBootTest
public class ProfissionalControllerTests {

    @MockBean
    private ProfissionalService service;

}
