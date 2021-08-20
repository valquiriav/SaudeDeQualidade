package br.com.letscode.saudedequalidade.Profissional;

import br.com.letscode.saudedequalidade.Exceptions.ExceptionResponse;
import br.com.letscode.saudedequalidade.Exceptions.ProfissionalNaoExistenteException;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(value="Operações relacionadas com os contatos dos profissionais.")
@RestController
@RequestMapping("/contato")
public class ProfissionalContatoController {

    private final ProfissionalRepository repository;
    private final ProfissionalContatoService service;

    @Autowired
    public ProfissionalContatoController(ProfissionalContatoService pservice, ProfissionalRepository profissionalRepository) {
        service = pservice;
        repository = profissionalRepository;
    }

    @ApiOperation(value="Procurar os contatos pelo id do profissional.")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Contatos encontrados com sucesso.", response = Profissional.class),
            @ApiResponse(code=404, message = "Não existe nenhum profissional com este ID.", response = ExceptionResponse.class)
    })
    @GetMapping("/findContatosByIdProfissional/{id}")
    public ResponseEntity<List<ProfissionalContatoDTO>> findByIdProfissional(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findProfissionalContatoByidProfissional(repository.findById(id).orElseThrow(ProfissionalNaoExistenteException::new)));
    }

    @ApiOperation(value="Criar um novo contato.")
    @ApiResponses(value = {
            @ApiResponse(code=201, message="Contatos encontrados com sucesso.", response = Profissional.class),
            @ApiResponse(code=404, message = "Não existe nenhum profissional com este ID.", response = ExceptionResponse.class)
    })
    @PostMapping("/criarContato/{idProfissional}")
    public ResponseEntity<ProfissionalContato> createProfissionalContato(@PathVariable Profissional idProfissional ,@RequestBody Integer telefone){
        ProfissionalContato pc = new ProfissionalContato(telefone,idProfissional);
        return ResponseEntity.status(201).body(service.createContatoProfissional(pc));
    }

    @ApiOperation(value="Buscar todos os contatos.")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Contatos encontrados com sucesso.", response = Profissional.class)
    })
    @GetMapping("/listarContatos")
    public ResponseEntity<List<ProfissionalContato>> listarContatos(){
        return ResponseEntity.ok().body(
                service.findContatos()
        );
    }
}
