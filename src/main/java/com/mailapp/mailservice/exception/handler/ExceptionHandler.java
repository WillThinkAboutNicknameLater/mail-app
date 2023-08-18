package com.mailapp.mailservice.exception.handler;

import com.mailapp.mailservice.dto.response.common.ErrorBody;
import com.mailapp.mailservice.dto.response.common.UnsuccessfulResponseBody;
import com.mailapp.mailservice.exception.ConflictException;
import com.mailapp.mailservice.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandler {
    private ResponseEntity<UnsuccessfulResponseBody> buildResponseEntity(Exception ex, HttpStatus status) {
        ErrorBody errorBody = ErrorBody.builder()
                                       .message(ex.getLocalizedMessage())
                                       .build();

        return new ResponseEntity<>(new UnsuccessfulResponseBody(errorBody), status);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    public ResponseEntity<UnsuccessfulResponseBody> handleNotFoundException(NotFoundException ex) {
        return buildResponseEntity(ex, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ConflictException.class)
    public ResponseEntity<UnsuccessfulResponseBody> handleConflictException(ConflictException ex) {
        return buildResponseEntity(ex, HttpStatus.CONFLICT);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Set<ErrorBody> errorBodies = ex.getFieldErrors()
                                       .stream()
                                       .map(error -> ErrorBody.builder()
                                                              .message(error.getDefaultMessage())
                                                              .build())
                                       .collect(Collectors.toSet());

        return new ResponseEntity<>(new UnsuccessfulResponseBody(errorBodies), HttpStatus.BAD_REQUEST);
    }
}
