package br.com.letscode.saudedequalidade.Profissional;

import br.com.letscode.saudedequalidade.Exceptions.ProfissionalNaoExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ProfissionalContatoController {

    private ProfissionalRepository repository;
    private ProfissionalContatoService service;

    @Autowired
    public ProfissionalContatoController(ProfissionalContatoService pservice, ProfissionalRepository profissionalRepository) {
        service = pservice;
        repository = profissionalRepository;
    }

    @GetMapping("/findContatosByIdProfissional/{id}")
    public ResponseEntity<List<ProfissionalContatoDTO>> findByIdProfissional(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findProfissionalContatoByidProfissional(repository.findById(id).orElseThrow(ProfissionalNaoExistenteException::new)));
    }

    @PostMapping("/criarContato/{idProfissional}")
    public ResponseEntity<ProfissionalContato> createProfissionalContato(@PathVariable Profissional idProfissional ,@RequestBody Integer telefone){
        ProfissionalContato pc = new ProfissionalContato(telefone,idProfissional);
        return ResponseEntity.status(201).body(service.createContatoProfissional(pc));
    }

    @GetMapping("/listarContatos")
    public ResponseEntity<List<ProfissionalContato>> listarContatos(){
        return ResponseEntity.ok().body(
                service.findContatos()
        );
    }
}
