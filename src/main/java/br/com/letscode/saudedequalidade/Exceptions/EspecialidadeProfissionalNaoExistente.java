package br.com.letscode.saudedequalidade.Exceptions;

public class EspecialidadeProfissionalNaoExistente extends RuntimeException{

    private static final String MENSAGEM_PADRAO = "Não existe nenhum médico com esta especialidade.";

    public EspecialidadeProfissionalNaoExistente(){
        this(MENSAGEM_PADRAO);
    }

    public EspecialidadeProfissionalNaoExistente(String mensagem){
        super(mensagem);
    }
}
