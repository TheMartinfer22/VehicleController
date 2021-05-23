package team.martin.controlador.api.controller.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import team.martin.controlador.api.controller.exceptions.DadosEmUso;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {



    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Resultado result = new Resultado();
        result.setStatus(status.value());
        result.setMotivo("O arqumento que foi digitado não é válido.");
        result.setTime(LocalDateTime.now());

        return handleExceptionInternal(ex, result, headers, status, request);
    }


    @ExceptionHandler(DadosEmUso.class)
    public ResponseEntity<Object> handleDadosEmUso(DadosEmUso ex, WebRequest request){
        Resultado result = new Resultado();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        result.setStatus(status.value());
        result.setMotivo(ex.getMessage());
        result.setTime(LocalDateTime.now());

        return handleExceptionInternal(ex, result, new HttpHeaders(), status, request);
    }

}
