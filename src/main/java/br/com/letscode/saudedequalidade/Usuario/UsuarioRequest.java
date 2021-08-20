package br.com.letscode.saudedequalidade.Usuario;

import br.com.letscode.saudedequalidade.Perfil.Perfil;
import br.com.letscode.saudedequalidade.Perfil.PerfilRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRequest {
    private String email;
    private String senha;
    private List<Long> perfil;


    public Usuario convert(PerfilRepository perfilRepository) {
        String senhaCrypto = new BCryptPasswordEncoder().encode(this.senha);
        List<Perfil> perfis = new ArrayList<>();
        this.perfil.stream().map(id -> perfis.add(perfilRepository.findById(id).get()));
        return new Usuario(this.email,senhaCrypto,perfis);
    }
}
