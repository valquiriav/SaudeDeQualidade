package br.com.letscode.saudedequalidade.Paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "paciente")
@Table(name = "paciente")

public class Paciente {

    @Id
    @GeneratedValue
    @Column(name = "identificador_paciente", nullable = false)
    private Long id;

    @Column(name = "nome_paciente", nullable = false)
    private String nome;

    @Column(name = "sobrenome_paciente", nullable = false)
    private String sobrenome;

    @Column(name = "regiao", nullable = false)
    private String regiao;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate data_nascimento;

    @Column(name = "idade", nullable = false)
    private Period idade;

    public Paciente(Long id, String nome, String sobrenome, String regiao, LocalDate data_nascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.regiao = regiao;
        this.data_nascimento = data_nascimento;
        this.idade = Period.between(data_nascimento, LocalDate.now());
    }
}