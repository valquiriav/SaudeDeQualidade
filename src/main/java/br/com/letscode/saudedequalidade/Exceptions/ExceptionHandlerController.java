package br.com.letscode.saudedequalidade.Exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ProfissionalNaoExistenteException.class)
    public ResponseEntity<ExceptionResponse> handleProfissionalNaoExistenteException(ProfissionalNaoExistenteException ex) {
        log.info(ex.getMessage());
        return new ResponseEntity<>(
                new ExceptionResponse(ex.getMessage(), "Não existe nenhum profissional com este ID."),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(PacienteNaoExistenteException.class)
    public ResponseEntity<ExceptionResponse> handlePacienteNaoExistenteException(PacienteNaoExistenteException ex) {
        log.info(ex.getMessage());
        return new ResponseEntity<>(
                new ExceptionResponse(ex.getMessage(), "Não existe nenhum paciente com este ID."),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(EspecialidadeProfissionalNaoExistente.class)
    public ResponseEntity<ExceptionResponse> handleEspecialidadeProfissionalNaoExistente(EspecialidadeProfissionalNaoExistente ex) {
        log.info(ex.getMessage());
        return new ResponseEntity<>(
                new ExceptionResponse(ex.getMessage(), "Não existe nenhum médico com esta especialidade."),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ProfissionalNaoDisponivelException.class)
    public ResponseEntity<ExceptionResponse> handleProfissionalNaoDisponivelException(ProfissionalNaoDisponivelException ex) {
        log.info(ex.getMessage());
        return new ResponseEntity<>(
                new ExceptionResponse(ex.getMessage(), "Não tem nenhum profissional disponivel nesse dia da semana."),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(RegiaoProfissionalNaoEncontrado.class)
    public ResponseEntity<ExceptionResponse> handleRegiaoProfissionalNaoEncontrado(RegiaoProfissionalNaoEncontrado ex){
        log.info(ex.getMessage());
        return new ResponseEntity<>(
                new ExceptionResponse(ex.getMessage(),"Não existe nenhum profissional atuando nesta região."),
                HttpStatus.BAD_REQUEST
        );
    }


}
