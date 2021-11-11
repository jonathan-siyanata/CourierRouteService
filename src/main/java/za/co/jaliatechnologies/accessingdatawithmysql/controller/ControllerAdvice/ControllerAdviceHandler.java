package za.co.jaliatechnologies.accessingdatawithmysql.controller.ControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.ControllerAdviceDto;
import za.co.jaliatechnologies.accessingdatawithmysql.exception.EmptyInputException;
import za.co.jaliatechnologies.accessingdatawithmysql.exception.ValidationException;

import java.util.Date;

@ControllerAdvice
public class ControllerAdviceHandler {

    //Handle specific exception by creating a class
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<?> handleEmptyInput(EmptyInputException emptyInputException, WebRequest request){
        ControllerAdviceDto specificErrorDetails = new ControllerAdviceDto(new Date(), emptyInputException.getErrorMessage(), request.getDescription(false));
        return new ResponseEntity(specificErrorDetails, HttpStatus.BAD_REQUEST);
    }
    //Handle specific exception by creating a class
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException validationException, WebRequest request){
        ControllerAdviceDto specificErrorDetails = new ControllerAdviceDto(new Date(), validationException.getErrorMessage(), request.getDescription(false));
        return new ResponseEntity(specificErrorDetails, HttpStatus.NOT_FOUND);
    }

    //Handle global exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> HandleException(Exception exception, WebRequest request){
        ControllerAdviceDto globalErrorDetails = new ControllerAdviceDto(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(globalErrorDetails, HttpStatus.NOT_FOUND);
    }
}
