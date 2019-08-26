package com.demo.demo1.controller;

import com.demo.demo1.dto.ExceptionMessageDto;
import com.demo.demo1.exception.DataNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionHandlerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Handles the exception when any data (Books, Authors, etc) do not exist in the DB
     *
     * @return Exception message with status code 404
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = DataNotFoundException.class)
    public ExceptionMessageDto handleException(DataNotFoundException e) {
        return getExceptionMessageDto(HttpStatus.NOT_FOUND, "Data Not Found", e);
    }

    /**
     * Handles any other exception
     *
     * @return Exception message with status code 500
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ExceptionMessageDto handleException(Exception e) {
        return getExceptionMessageDto(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", e);
    }

    private ExceptionMessageDto getExceptionMessageDto(HttpStatus status, String errorMessage, Exception exception) {
        logger.error(errorMessage, exception);
        return new ExceptionMessageDto(status.value(), errorMessage, exception.getMessage());
    }

}