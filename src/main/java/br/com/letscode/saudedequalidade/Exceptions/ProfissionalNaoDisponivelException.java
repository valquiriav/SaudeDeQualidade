package br.com.letscode.saudedequalidade.Exceptions;

public class ProfissionalNaoDisponivelException extends RuntimeException{

    private static final String MENSAGEM_PADRAO = "Não existe nenhum profissional disponivel nesse dia da semana.";

    public ProfissionalNaoDisponivelException(){
        this(MENSAGEM_PADRAO);
    }

    public ProfissionalNaoDisponivelException(String message){
        super(message);
    }
}
