package br.com.letscode.saudedequalidade.Profissional;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="profissional")
@Table(name="profissional")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="identificador_profissional",nullable = false)
    private Long id;

    @Column(name="nome_profissional",nullable = false)
    private String nome;

    @Column(name="sobrenome_profissional",nullable = false)
    private String sobrenome;

    @Column(name="especialidade",nullable = false)
    private String especialidade;

    @Column(name="dia_disponivel",nullable = false)
    private String diaDisponivel;

    @Column(name="regiao",nullable = false)
    private String regiao;

}
