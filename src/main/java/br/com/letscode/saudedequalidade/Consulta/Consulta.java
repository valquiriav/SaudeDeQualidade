package br.com.letscode.saudedequalidade.Consulta;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue
    private Long id;
}
