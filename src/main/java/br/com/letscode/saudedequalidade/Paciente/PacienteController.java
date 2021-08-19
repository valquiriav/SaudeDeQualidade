package br.com.letscode.saudedequalidade.Paciente;

import br.com.letscode.saudedequalidade.Exceptions.ExceptionResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Operações relacionadas com os Pacientes.")
@RestController
@RequestMapping("/paciente")



public class PacienteController {

    private PacienteService service;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        service = pacienteService;
    }

    @ApiOperation(value = "Listar todos os pacientes do banco de dados.", response = Paciente.class)
    @ApiResponse(code = 200, message = "Pacientes listados com sucesso.", response = Paciente.class)
    @GetMapping("/listarPacientes")
    public List<Paciente> getPacientes() {
        return service.getPacientes();
    }

    @ApiOperation(value = "Buscar um paciente pelo ID.", response = Paciente.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Paciente encontrado com sucesso.", response = Paciente.class),
            @ApiResponse(code = 404, message = "Este ID é inválido.", response = ExceptionResponse.class)
    })
    @GetMapping("/id")
    public ResponseEntity<Paciente> getPacienteByID(@PathVariable Long aLong) {
        return ResponseEntity.ok().body(service.getPacienteByID(aLong));
    }

    @ApiOperation(value = "Criar um novo paciente.", response = Paciente.class)
    @ApiResponse(code = 201, response = Paciente.class, message = "Paciente criado com sucesso.")
    @PostMapping("/createPaciente")
    public ResponseEntity<Paciente> createNovoPaciente(@RequestBody Paciente novoPaciente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveNewPaciente(novoPaciente));
    }
}
