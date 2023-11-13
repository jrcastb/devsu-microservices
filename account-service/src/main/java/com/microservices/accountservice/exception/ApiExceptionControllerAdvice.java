package com.microservices.accountservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice(annotations = RestController.class)
public class ApiExceptionControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ApiExceptionControllerAdvice.class);

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError handleBadRequest(Exception ex){
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        logger.info("Dentro de la excepcion handleException");
        return new ApiError(
                ex.getMessage()
        );
    }
}
