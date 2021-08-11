package br.com.letscode.saudedequalidade.Exceptions;

public class ProfissionalNaoExistenteException extends RuntimeException{

    private static final String MENSAGEM = "Nenhum profissional esta cadastrado com este ID.";

    public ProfissionalNaoExistenteException(){
        this(MENSAGEM);
    }

    public ProfissionalNaoExistenteException(String mensagem){
        super(mensagem);
    }
}
