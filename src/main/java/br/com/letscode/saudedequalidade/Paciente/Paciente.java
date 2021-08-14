package br.com.letscode.saudedequalidade.Paciente;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue
    private Long id;

}
