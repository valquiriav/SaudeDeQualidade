package br.com.letscode.saudedequalidade.Usuario;

import br.com.letscode.saudedequalidade.Perfil.PerfilRepository;
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
@RequestMapping("users")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    private final PerfilRepository perfilRepository;

    @Autowired
    public UsuarioController(UsuarioRepository repository, PerfilRepository repository2){
        usuarioRepository = repository;
        perfilRepository = repository2;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> buscarUsuarios(){
        return ResponseEntity.ok().body(UsuarioDTO.convertList(usuarioRepository.findAll()));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrar(
            @RequestBody UsuarioRequest usuarioRequest,
            UriComponentsBuilder uriComponentsBuilder
    ){
        Usuario usuario = usuarioRequest.convert(perfilRepository);
        usuarioRepository.save(usuario);
        URI uri = uriComponentsBuilder.path("/users/{id}")
                .buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(UsuarioDTO.of(usuario));
    }
}
