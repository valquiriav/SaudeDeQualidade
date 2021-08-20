package br.com.letscode.saudedequalidade.Authentication;

import br.com.letscode.saudedequalidade.Usuario.Usuario;
import br.com.letscode.saudedequalidade.Usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {


    private UsuarioRepository usuarioRepository;

    @Autowired
    public AuthenticationService(UsuarioRepository repository){
        usuarioRepository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Email não encontrado"));
    }
}
