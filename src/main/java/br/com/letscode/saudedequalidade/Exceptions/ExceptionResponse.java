package br.com.letscode.saudedequalidade.Exceptions;

import java.time.LocalDateTime;

public class ExceptionResponse {

    private LocalDateTime horaOcorrencia = LocalDateTime.now();
    private String mensagemExcessão;
    private String detalhes;

    ExceptionResponse(String exceptionMessage, String details) {
        mensagemExcessão = exceptionMessage;
        detalhes = details;
    }

    public LocalDateTime getTimeOccurrence() {
        return horaOcorrencia;
    }

    public String getExceptionMessage() {
        return mensagemExcessão;
    }

    public String getDetails() {
        return detalhes;
    }
}
