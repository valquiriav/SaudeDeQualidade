package br.com.letscode.saudedequalidade.Exceptions;

public class RegiaoProfissionalNaoEncontrado extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "Nenhum profissional atua nesta região.";

    public RegiaoProfissionalNaoEncontrado(){
        this(DEFAULT_MESSAGE);
    }

    public RegiaoProfissionalNaoEncontrado(String message){
        super(message);
    }
}
