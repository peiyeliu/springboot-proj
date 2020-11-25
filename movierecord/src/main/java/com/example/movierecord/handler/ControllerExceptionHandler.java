package com.example.movierecord.handler;

import com.example.movierecord.exception.InvalidRequestException;
import com.example.movierecord.exception.NotFoundException;
import com.example.movierecord.resource.ErrorResource;
import com.example.movierecord.resource.FieldResource;
import com.example.movierecord.resource.InvalidErrorResource;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception{
        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!= null){
            throw e;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("error/error");
        return modelAndView;
    }

}
