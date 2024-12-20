package ru.atikhonov.pirdemo.backend.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.atikhonov.pirdemo.backend.exception.ValidateException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<AppError> catchResourceNotFoundException(ValidateException e) {
        return new ResponseEntity<>(new AppError(e.getStatus().value(), e.getMessage()), e.getStatus());
    }
}
