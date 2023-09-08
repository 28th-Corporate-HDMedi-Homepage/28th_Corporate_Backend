package com.kusitms.hdmedi.exception;


import com.kusitms.hdmedi.exception.utilException.MailException;
import com.kusitms.hdmedi.exception.utilException.NewsException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class UtilExceptionHandler {
    @ExceptionHandler(MailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleEmailExistsException(MailException e, HttpServletRequest request) {
        log.warn("Mail-001> 요청 URI: " + request.getRequestURI() + ", 에러 메세지: " + e.getMessage());
        return new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Mail-001", e.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(NewsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handelNewsExistsException(NewsException e, HttpServletRequest request){
        log.warn("News API > 요청 URI: " + request.getRequestURI() + ", 에러 메세지: " + e.getMessage());
        return new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "News", e.getMessage(), request.getRequestURI());
    }
}