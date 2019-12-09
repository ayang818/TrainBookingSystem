package com.ayang818.trainbooking.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CustomizeExceptionHandler
 * @Description 全局的异常处理
 * @Author 杨丰畅
 * @Date 2019/12/4 20:47
 **/
@ControllerAdvice
public class CustomizeExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomizeExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    ModelAndView handle(HttpServletRequest request, Throwable ex, Model model, HttpServletResponse response) throws IOException {
        LOGGER.info(ex.getMessage());
        return new ModelAndView(request.getRequestURI());
    }
}