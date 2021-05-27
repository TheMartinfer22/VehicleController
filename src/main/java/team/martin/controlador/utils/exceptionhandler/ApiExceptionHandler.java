package team.martin.controlador.utils.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import team.martin.controlador.utils.exceptions.DadosEmUso;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public void handleNoSuchElementException(){

    }

}
