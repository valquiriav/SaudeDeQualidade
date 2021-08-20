package br.com.letscode.saudedequalidade.Exceptions;

public class ConsultaNaoExiste extends RuntimeException{
    private static final String MENSAGEM_PADRAO = "Não existe consulta com esse id.";

    public ConsultaNaoExiste() {
        this(MENSAGEM_PADRAO);
    }

    public ConsultaNaoExiste(String mensagem) {
        super(mensagem);
    }
}
