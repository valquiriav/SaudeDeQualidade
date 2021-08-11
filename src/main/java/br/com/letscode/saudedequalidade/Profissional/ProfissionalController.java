package br.com.letscode.saudedequalidade.Profissional;

import br.com.letscode.saudedequalidade.Exceptions.ExceptionResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value="Operações relacionadas com os Médicos (Profissionais).")
@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

    private ProfissionalService service;
    @Autowired
    public ProfissionalController(ProfissionalService profissionalService){
        service = profissionalService;
    }

    @ApiOperation(value="Listar todos os profissionais do banco de dados.", response=Profissional.class)
    @ApiResponse(code=200, message="Profissionais listados com sucesso.", response=Profissional.class)
    @GetMapping("/listarProfissionais")
    public List<Profissional> getProfissionais(){
        return service.getProfissionais();
    }

    @ApiOperation(value="Buscar um profissional pelo ID.", response=Profissional.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Profissional encontrado com sucesso.", response = Profissional.class),
            @ApiResponse(code = 400, message = "Este ID é invalido.", response = ExceptionResponse.class)
    })
    @GetMapping("/{id}")
    public Profissional getProfissionalByID(@PathVariable Long id){
        return service.getProfissionalByID(id);
    }

    @ApiOperation(value="Criar um novo profissional.", response = Profissional.class)
    @ApiResponse(code=201, response= Profissional.class, message = "Profissional criado com sucesso.")
    @PostMapping("/createProfissional")
    public Profissional createNovoProfissional(@RequestBody Profissional novoProfissional){
        return service.saveNewProfissional(novoProfissional);
    }

    @ApiOperation(value="Buscar um profissional pela sua especialidade por meio do parâmetro.")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Profissionais encontrados com sucesso.", response = Profissional.class),
            @ApiResponse(code=400, message = "Não existe nenhum profissional com esta especialidade.", response = ExceptionResponse.class)
    })
    @GetMapping("/buscarEspecialidade")
    public Profissional findProfissionalByEspecialidade(@RequestParam String especialidade){
        return service.findProfissionalByEspecialidade(especialidade);
    }
}
