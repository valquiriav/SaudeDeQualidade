package br.com.letscode.saudedequalidade.Profissional;


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

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "contato_profissional")
@Table(name = "contato_profissional")
public class ProfissionalContato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "numero_telefone", nullable = false)
    private int numeroTelefone;

    @ManyToOne
    @JoinColumn(name = "identificador_profissional", referencedColumnName = "identificador_profissional", nullable = false)
    private Profissional idProfissional;
}
