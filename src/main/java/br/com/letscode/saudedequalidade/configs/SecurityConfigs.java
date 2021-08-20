package br.com.letscode.saudedequalidade.configs;

import br.com.letscode.saudedequalidade.Authentication.AuthenticationService;
import br.com.letscode.saudedequalidade.Authentication.TokenService;
import br.com.letscode.saudedequalidade.Filter.Autenticar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigs extends WebSecurityConfigurerAdapter {

    private AuthenticationService service;

    private TokenService tokenService;
    @Autowired
    public SecurityConfigs(AuthenticationService authenticationService, TokenService token){
        service = authenticationService;
        tokenService = token;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/cursos").permitAll()
                .antMatchers("/paciente/*").permitAll()
                .antMatchers("/profissional/*").permitAll()
                .antMatchers("/consulta/*").permitAll()
                .antMatchers("/contato/*").permitAll()
                .antMatchers("/users").hasAnyAuthority("PROFISSIONAL", "ADMIN", "PACIENTE")
                .antMatchers("/login").permitAll()
                .antMatchers(HttpMethod.GET, "/cursos/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(new Autenticar(tokenService), UsernamePasswordAuthenticationFilter.class);
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }
}
