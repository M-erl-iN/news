package com.example.demo.handler;

import com.example.demo.dto.ErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(Throwable.class)
    public ErrorDto handleException(Throwable ex, HttpServletRequest request, HttpServletResponse response) {
        ErrorDto errorResponse = ErrorDto.builder()
                .code(500)
                .message("Непредвиденная ошибка на сервере: " + ex.getLocalizedMessage())
                .url(request.getRequestURI())
                .build();
        log.error(ex.getLocalizedMessage());
        ex.printStackTrace();
        return errorResponse;
    }
}
