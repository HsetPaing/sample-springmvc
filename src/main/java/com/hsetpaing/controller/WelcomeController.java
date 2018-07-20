package com.hsetpaing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name", getLoggedInUserName());
		return "welcome";
	}

	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET) public String
	 * showLoginPage() { return "login"; }
	 * 
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public String
	 * handleUserLogin(ModelMap model, @RequestParam String name, @RequestParam
	 * String password) {
	 * 
	 * if (!loginService.validateUser(name, password)) { model.put("errorMessage",
	 * "Invalid Credentials"); return "login"; }
	 * 
	 * model.put("name", name); return "welcome"; }
	 */
}
