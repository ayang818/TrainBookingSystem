package com.ayang818.trainbooking.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CustomizeExceptionHandler
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/12/4 20:47
 **/
@ControllerAdvice
public class CustomizeExceptionHandler {
    //@ExceptionHandler(Exception.class)
    //ModelAndView handle(HttpServletRequest request, Throwable ex, Model model, HttpServletResponse response) throws IOException {
    //    return null;
    //}
}
