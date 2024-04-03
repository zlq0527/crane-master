package com.crane.system.utils;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局捕获异常
 */
@Data
@Slf4j
@Component
@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    private Integer code = 500;

    private String message;


    public GlobalExceptionHandler() {
    }


    public GlobalExceptionHandler(String message) {
        this.message = message;
    }

    public GlobalExceptionHandler(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    /**
     * 处理全局所有的异常
     *
     * @param e e
     * @return {@link AppResponse}
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AppResponse exception(Exception e) {
        log.info("--------------------------------全局异常捕获处理--------------------------------");
        e.printStackTrace();
        return new AppResponse(((GlobalExceptionHandler) e).code,e.getMessage());
    }


}
