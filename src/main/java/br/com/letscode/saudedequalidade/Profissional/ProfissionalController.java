package br.com.letscode.saudedequalidade.Profissional;

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


@Api(value="Operações relacionadas com os Médicos (Profissionais).")
@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

    private final ProfissionalService service;
    @Autowired
    public ProfissionalController(ProfissionalService profissionalService){
        service = profissionalService;
    }

    @ApiOperation(value="Listar todos os profissionais do banco de dados.", response=Profissional.class)
    @ApiResponse(code=200, message="Profissionais listados com sucesso.", response=Profissional.class)
    @GetMapping("/listarProfissionais")
    public List<ProfissionalDTO> getProfissionais(){

        return service.getProfissionais();
    }

    @ApiOperation(value="Buscar um profissional pelo ID.", response=Profissional.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Profissional encontrado com sucesso.", response = Profissional.class),
            @ApiResponse(code = 404, message = "Este ID é invalido.", response = ExceptionResponse.class)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Profissional> getProfissionalByID(@PathVariable Long id){

        return ResponseEntity.ok().body(service.getProfissionalByID(id));
    }

    @ApiOperation(value="Criar um novo profissional.", response = Profissional.class)
    @ApiResponse(code=201, response= Profissional.class, message = "Profissional criado com sucesso.")
    @PostMapping("/createProfissional")
    public ResponseEntity<Profissional> createNovoProfissional(@RequestBody Profissional novoProfissional){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveNewProfissional(novoProfissional));
    }

    @ApiOperation(value="Buscar um profissional pela sua especialidade.")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Profissionais encontrados com sucesso.", response = Profissional.class),
            @ApiResponse(code=404, message = "Não existe nenhum profissional com esta especialidade.", response = ExceptionResponse.class)
    })
    @GetMapping("/buscarPorEspecialista/{especialidade}")
    public ResponseEntity<List<ProfissionalDTO>> findProfissionalByEspecialidade(@PathVariable String especialidade){
        return ResponseEntity.ok().body(service.findProfissionalByEspecialidade(especialidade));
    }

    @ApiOperation(value="Buscar um profissional pela sua disponibilidade. A busca é feita por"+
    " dias da semana.", response = Profissional.class)
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Profissionais encontrados com sucesso.", response = Profissional.class),
            @ApiResponse(code=404, message = "Não existe nenhum profissional disponivel nesse dia"+
            " ou você digitou o dia da semana de forma errada.", response = ExceptionResponse.class)
    })
    @GetMapping("/buscarPorDisponibilidade/{disponibilidade}")
    public ResponseEntity<List<ProfissionalDTO>> findProfissionalByDisponibilidade(@PathVariable String disponibilidade){
        return ResponseEntity.status(200).body(service.findProfissionalByDisponibilidade(disponibilidade));
    }

    @ApiOperation(value="Buscar um profissional pela região onde atua.")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Profissionais encontrados com sucesso.",response = Profissional.class),
            @ApiResponse(code=404,message="Não existem profissionais atuando nesta região."
                    , response = ExceptionResponse.class)
    })
    @GetMapping("/buscarPorRegião/{regiao}")
    public ResponseEntity<List<ProfissionalDTO>> findProfissionalByRegiao(@PathVariable String regiao){
        return ResponseEntity.status(200).body(service.findProfissionalByRegiao(regiao));
    }


}
