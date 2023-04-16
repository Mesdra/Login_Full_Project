package br.com.mesdra.springapi.exception;


import br.com.mesdra.springapi.exception.model.StandardError;
import br.com.mesdra.springapi.exception.model.ValidationError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExeptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseEntity<StandardError> duplicatedKeyException(DataIntegrityViolationException ex) {
        return ResponseEntity.badRequest().body(
                StandardError.builder()
                             .timestamp(LocalDateTime.now())
                             .status(HttpStatus.BAD_REQUEST.value())
                             .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                             .message(verifyDupKey(ex.getMostSpecificCause().getMessage()))
                             .build()
                                               );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<ValidationError> validationError(MethodArgumentNotValidException ex) {
        ValidationError error =
                new ValidationError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Validation Error",
                                    "Erro de " +
                                            "validação de formulario");

        for (FieldError er : ex.getBindingResult().getFieldErrors()) {
            error.addError(er.getField(), er.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    private String verifyDupKey(String message) {
        if (message.contains("Unique index or primary key violation")) {
            return "Este E-mail já foi registrado";
        } else {
            return "Validação de chave duplicada";
        }
    }


}
