package br.com.letscode.saudedequalidade.Login;


import br.com.letscode.saudedequalidade.Authentication.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;



@RestController
@RequestMapping("/login")
public class LoginController {

    private AuthenticationManager authenticationManager;

    private TokenService tokenService;

    @Autowired
    public LoginController(AuthenticationManager manager, TokenService service){
        authenticationManager = manager;
        tokenService = service;
    }

    @PostMapping
    public ResponseEntity<LoginDTO> login(@RequestBody LoginRequest user){
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getSenha());
        try {
            Authentication authentication = authenticationManager.authenticate(login);
            String tokeJwt = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new LoginDTO(tokeJwt, "Bearer"));
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
