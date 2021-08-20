package br.com.letscode.saudedequalidade.Perfil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/perfis")
public class PerfilController {

    private PerfilRepository perfilRepository;

    @Autowired
    public PerfilController(PerfilRepository repository){
        perfilRepository = repository;
    }

    @GetMapping
    public ResponseEntity<List<PerfilDTO>> buscaPerfis(){
        List<Perfil> perfis = perfilRepository.findAll();
        return ResponseEntity.ok(PerfilDTO.convert(perfis));
    }
    @PostMapping
    public ResponseEntity<PerfilDTO> cadastrar(
            @RequestBody PerfilRequest perfilRequest,
            UriComponentsBuilder uriComponentsBuilder
    ){
        Perfil perfil = perfilRequest.convert();
        perfilRepository.save(perfil);
        URI uri = uriComponentsBuilder.path("/perfis/{id}")
                .buildAndExpand(perfil.getId()).toUri();

        return ResponseEntity.created(uri).body(new PerfilDTO(perfil));
    }
}
