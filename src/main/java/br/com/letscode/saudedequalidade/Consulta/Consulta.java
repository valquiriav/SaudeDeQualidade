package br.com.letscode.saudedequalidade.Consulta;

import br.com.letscode.saudedequalidade.Paciente.Paciente;
import br.com.letscode.saudedequalidade.Profissional.Profissional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name="consulta")
@Table(name="consulta")
@NoArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue
    @Column(name="identificador_consulta",nullable = false)
    private Long id;

    @ManyToOne @JoinColumn(name = "identificador_profissional", referencedColumnName = "identificador_profissional",nullable = false)
    private Profissional idProfissional;

    @ManyToOne @JoinColumn(name = "identificador_paciente", referencedColumnName = "identificador_paciente",nullable = false)
    private Paciente idPaciente;

}
