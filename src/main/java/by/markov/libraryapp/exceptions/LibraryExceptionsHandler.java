package by.markov.libraryapp.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class LibraryExceptionsHandler {

    @ExceptionHandler(PrintedProductionNotFoundException.class)
    public ResponseEntity<?> handleIncorrectProductionsData(PrintedProductionNotFoundException e) {
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(PrintedProductionAlreadyExistsException.class)
    public ResponseEntity<?> handleRepeatableProductionsData(PrintedProductionAlreadyExistsException e) {
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
