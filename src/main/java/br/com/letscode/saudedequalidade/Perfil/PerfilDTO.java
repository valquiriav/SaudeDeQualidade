package br.com.letscode.saudedequalidade.Perfil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PerfilDTO {
    private Long id;
    private String nome;

    public PerfilDTO(Perfil perfil){
        this.id = perfil.getId();
        this.nome = perfil.getNome();
    }

    public static PerfilDTO of(Perfil perfil){
        return new PerfilDTO(perfil.getId(),perfil.getNome());
    }
    public static List<PerfilDTO> convert(List<Perfil> perfis){
        return perfis
                .stream()
                .map(PerfilDTO::of)
                .collect(Collectors.toList());
    }
}
