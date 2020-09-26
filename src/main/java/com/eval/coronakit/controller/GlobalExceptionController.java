package com.eval.coronakit.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.exception.CoronaException;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(CoronaException.class)
	public ModelAndView handleImsException(CoronaException exception) {
		return new ModelAndView("errPage","errMsg",exception.getMessage());
	}
}
