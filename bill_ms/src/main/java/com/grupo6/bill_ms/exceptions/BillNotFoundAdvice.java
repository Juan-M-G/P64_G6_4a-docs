package com.grupo6.bill_ms.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
@ResponseBody
public class BillNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(BillNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String EntityNotFoundAdvice(BillNotFoundException ex){
        return ex.getMessage();
    }
}