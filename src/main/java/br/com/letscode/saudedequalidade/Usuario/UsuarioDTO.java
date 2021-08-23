package br.com.letscode.saudedequalidade.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

    private String email;


    public static UsuarioDTO of(Usuario usuario){
        return new UsuarioDTO(usuario.getEmail());
    }

    public static List<UsuarioDTO> convertList(List<Usuario> list){
        return list
                .stream()
                .map(UsuarioDTO::of)
                .collect(Collectors.toList());
    }
}
