package br.com.letscode.saudedequalidade.Perfil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PerfilRequest {
    private String nome;

    public Perfil convert() {
        return new Perfil(nome);
    }
}
