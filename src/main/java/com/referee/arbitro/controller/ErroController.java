package com.referee.arbitro.controller;

import org.springframework.boot.web.servlet.error.ErrorController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ErroController implements ErrorController {

	// …
	/*
	 * @RequestMapping("/error") public ModelAndView handleError(HttpServletResponse
	 * response) { ModelAndView modelAndView = new ModelAndView();
	 * 
	 * if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
	 * modelAndView.setViewName("error-404"); } else if (response.getStatus() ==
	 * HttpStatus.FORBIDDEN.value()) { modelAndView.setViewName("error-403"); } else
	 * if (response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	 * modelAndView.setViewName("error-500"); } else {
	 * modelAndView.setViewName("error"); }
	 * 
	 * return modelAndView; }
	 * 
	 * 
	 * public String getErrorPath() { return "/error"; }
	 * 
	 * 
	 * }
	 * 
	 */
	@RequestMapping("/error")
	public ModelAndView handleError() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		return modelAndView;
	}

	public String getErrorPath() {
		return "/error";
	}
}
