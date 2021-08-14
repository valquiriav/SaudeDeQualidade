package br.com.letscode.saudedequalidade.Exceptions;

public class PacienteNaoExistenteException extends RuntimeException{

    private static final String MENSAGEM = "Nenhum paciente está cadastrado com este ID.";

    public PacienteNaoExistenteException(){
        this(MENSAGEM);
    }

    public PacienteNaoExistenteException(String mensagem){
        super(mensagem);
    }
}
