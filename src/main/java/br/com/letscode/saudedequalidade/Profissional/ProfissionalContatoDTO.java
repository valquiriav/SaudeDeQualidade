package br.com.letscode.saudedequalidade.Profissional;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfissionalContatoDTO {

    private Integer numeroTelefone;

    private Long idProfissional;

    private String nome;


    public static ProfissionalContatoDTO of(ProfissionalContato profissional){
        return new ProfissionalContatoDTO(profissional.getNumeroTelefone(),profissional.getIdProfissional().getId()
                ,profissional.getIdProfissional().getNome());
    }
}
