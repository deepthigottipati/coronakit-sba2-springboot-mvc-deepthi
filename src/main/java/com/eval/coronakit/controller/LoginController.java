package com.eval.coronakit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eval.coronakit.exception.CoronaException;
import com.eval.coronakit.service.KitDetailService;

@Controller
public class LoginController {
	
	@Autowired
	KitDetailService kitDetailService;
	
	@RequestMapping("/custom-login")
	public String login() {
		try {
			kitDetailService.deleteAllKitItem();
		} catch (CoronaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login-form";
	}
	
	@RequestMapping("/custom-error")
	public String error() {
		return "error-page";
	}
	
	
}
