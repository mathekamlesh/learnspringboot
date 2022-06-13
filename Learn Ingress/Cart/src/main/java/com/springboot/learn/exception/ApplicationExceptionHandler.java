package com.springboot.learn.exception;

import com.springboot.learn.datamapper.CartMapper;
import com.springboot.learn.dto.GetCartResponse;
import com.springboot.learn.dto.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@Slf4j
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    private CartMapper cartMapper;

    @ExceptionHandler(value = {ApiException.class})
    protected ResponseEntity<Response<GetCartResponse>> handleApiException(Exception $ex){
        Response<GetCartResponse> response = cartMapper.createFailureResponse($ex);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Response<GetCartResponse>> handleOtherException(Exception $ex){
        Response<GetCartResponse> response = cartMapper.createInternalErrorResponse($ex);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
