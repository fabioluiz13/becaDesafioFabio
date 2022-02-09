package com.fabio.vendas.errors.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class TratamentoException extends ValidationException{



    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<DefaultException> handle(ValidationException e){

        DefaultException defaultException = new DefaultException();
        defaultException.setDataHora(LocalDateTime.now());
        defaultException.setStatus(HttpStatus.BAD_REQUEST.value());
        defaultException.setMesagem("Campo inválido");

        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<DefaultException> handle(ConstraintViolationException e){

        DefaultException defaultException = new DefaultException();
        defaultException.setDataHora(LocalDateTime.now());
        defaultException.setStatus(HttpStatus.BAD_REQUEST.value());
        defaultException.setMesagem("Campo deve ser preenchido!");

        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<DefaultException> handle(NoSuchElementException e){

        DefaultException defaultException = new DefaultException();
        defaultException.setDataHora(LocalDateTime.now());
        defaultException.setStatus(HttpStatus.BAD_REQUEST.value());
        defaultException.setMesagem("O id não corresponde");

        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);
    }

}
