package br.com.letscode.saudedequalidade.Paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "contato_paciente")
@Table(name = "contato_paciente")
public class PacienteContato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "numero_telefone_paciente", nullable = false)
    private Long numeroTelefonePaciente;

    @ManyToOne
    @JoinColumn(name = "identificador_paciente", referencedColumnName = "identificador_paciente", nullable = false)
    private Paciente idPaciente;
}
