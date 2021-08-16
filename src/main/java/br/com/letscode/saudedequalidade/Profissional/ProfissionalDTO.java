package br.com.letscode.saudedequalidade.Profissional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
public class ProfissionalDTO {

    private String nome;

    private String sobrenome;

    private String especialidade;

    private String diaDisponivel;

    private String regiao;


    public static ProfissionalDTO of(Profissional profissional) {
        return new ProfissionalDTO(profissional.getNome(), profissional.getSobrenome(),
                profissional.getEspecialidade(), profissional.getDiaDisponivel(), profissional.getRegiao());
    }

    public static List<ProfissionalDTO> convertToList(List<Profissional> list){
        return list.stream()
                .map(ProfissionalDTO::of)
                .collect(Collectors.toList());
    }
}
