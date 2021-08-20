package br.com.letscode.saudedequalidade.Authentication;

import br.com.letscode.saudedequalidade.Usuario.UsuarioRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import br.com.letscode.saudedequalidade.Usuario.Usuario;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TokenService {

    @Value("${config.token.secret}")
    private String secret;

    private UsuarioRepository repository;
    @Autowired
    public TokenService(UsuarioRepository usuarioRepository){
        repository = usuarioRepository;
    }
    public String gerarToken(Authentication authentication){
        Usuario user = (Usuario) authentication.getPrincipal();
        Date criacao = new Date();
        Date expiracao = new Date(criacao.getTime() + 1800000);

        return Jwts.builder().setIssuer("ONU")
                .setSubject(user.getId().toString())
                .setIssuedAt(criacao)
                .setExpiration(expiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validarToken(String token){
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Optional<Usuario> getUser(String token) {
        Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        Long id = Long.parseLong(body.getSubject());
        return repository.findById(id);
    }
}
