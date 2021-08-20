package br.com.letscode.saudedequalidade.Filter;

import br.com.letscode.saudedequalidade.Authentication.TokenService;
import br.com.letscode.saudedequalidade.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class Autenticar extends OncePerRequestFilter {

    private final TokenService tokenService;
    @Autowired
    public Autenticar(TokenService service){
        tokenService=service;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(httpServletRequest);
        boolean tokenValido = tokenService.validarToken(token);
        if(tokenValido){
            autenticar(token);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String getToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return  null;
        }
        return token.substring(7);
    }

    private void autenticar(String token){
        Optional<Usuario> user = tokenService.getUser(token);
        if(user.isPresent()){
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.get().getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
    }
}
