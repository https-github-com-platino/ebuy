package com.ebuy.shared.helper.exception;

import com.ebuy.shared.helper.exception.exceptions.ResourceNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler()
//    public String handleVerificationFailureException(ResourceNotFoundException e,
//                                                     HttpServletRequest request,
//                                                     HttpServletResponse response, Model model)
//    {
//        model.addAttribute("error_message", e.getMessage());
//        return "errors/404";
//    }
    @ExceptionHandler()
    public final String handleResourceNotFountException(ResourceNotFoundException ex,
                                                        WebRequest request, Model model){

        ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException(ex.getMessage());
        model.addAttribute("error_message", resourceNotFoundException.getMessage());
        return "errors/404";
    }
}

