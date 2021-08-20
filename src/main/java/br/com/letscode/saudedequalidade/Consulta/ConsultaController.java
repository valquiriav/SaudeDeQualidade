package br.com.letscode.saudedequalidade.Consulta;

import br.com.letscode.saudedequalidade.Exceptions.ExceptionResponse;
import br.com.letscode.saudedequalidade.Profissional.Profissional;
import br.com.letscode.saudedequalidade.Profissional.ProfissionalDTO;
import br.com.letscode.saudedequalidade.Profissional.ProfissionalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value="Operações relacionadas com as consultas.")
@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private ConsultaService service;
    @Autowired
    public ConsultaController(ConsultaService consultaService){ service = consultaService; }

    @ApiOperation(value="Listar todas as consultas do banco de dados.", response= Consulta.class)
    @ApiResponse(code=200, message="Consultas listadas com sucesso.", response=Consulta.class)
    @GetMapping("/listarConsultas")
    public List<Consulta> getConsultas(){
        return service.getConsultas();
    }


    @ApiOperation(value="Buscar uma consulta pelo ID.", response=Consulta.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta encontrada com sucesso.", response = Consulta.class),
            @ApiResponse(code = 404, message = "Este ID é invalido.", response = ExceptionResponse.class)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getConsultaByID(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getConsultaByID(id));
    }

    @ApiOperation(value="Buscar uma consulta pelo paciente.")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Consultas encontradas com sucesso.", response = Consulta.class),
            @ApiResponse(code=404, message = "Não existe nenhuma consulta com este paciente.", response = ExceptionResponse.class)
    })
    @GetMapping("/buscarPorPaciente/{id}")
    public ResponseEntity<List<Consulta>> findConsultaByPacienteId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getConsultaByPacienteId(id));
    }

    @ApiOperation(value="Buscar uma consulta pelo profissional.")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Consultas encontradas com sucesso.", response = Consulta.class),
            @ApiResponse(code=404, message = "Não existe nenhuma consulta com este profissional.", response = ExceptionResponse.class)
    })
    @GetMapping("/buscarPorProfissional/{id}")
    public ResponseEntity<List<Consulta>> findConsultaByProfissionalId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getConsultaByProfissionalId(id));
    }

    @ApiOperation(value="Criar uma nova Consulta.", response = Consulta.class)
    @ApiResponse(code=201, response= Consulta.class, message = "Consulta criada com sucesso.")
    @PostMapping("/createConsulta")
    public ResponseEntity<Consulta> saveNewConsulta(@RequestBody IDs ids){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveNewConsulta(ids));
    }

    @ApiOperation(value="Deleter consulta por id.")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Consultas deletada com sucesso.", response = Consulta.class),
            @ApiResponse(code=404, message = "Não existe nenhuma consulta com este id.", response = ExceptionResponse.class)
    })
    @DeleteMapping("/deletarConsulta/{id}")
    public void deleteConsultaById(@PathVariable Long id){
        service.deleteConsultaById(id);
    }
}
