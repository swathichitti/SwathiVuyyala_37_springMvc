package com.jfsfeb.springmvc.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringmvcController {
	@RequestMapping(path="/hello" ,method=RequestMethod.GET)
public ModelAndView showMessage() {
	ModelAndView modelAndView=new ModelAndView();
	modelAndView.setViewName("/WEB-INF/views/messagePage.jsp");
	
	return modelAndView;
}
	@RequestMapping(path="/getEmp",method=RequestMethod.GET)
	public String getEmp(@RequestParam(name="empId") int empIdVal ,HttpServletRequest req) {
		req.setAttribute("empId", empIdVal);
		return "/WEB-INF/views/getEmp.jsp";
		
	}
	@GetMapping("/pathVar/{city}")
	public String pathVar(@PathVariable (name="city") String cityName,ModelMap modelMap) {
		modelMap.addAttribute("cityName", cityName);
		return "pathVariable";
	}
	
	
	
	@GetMapping("/redirect")
	public String getRedirect() {
		
		return "redirect:http://www.youtube.com";
	}
	
	@GetMapping("/forward")
	public String forwardReq() {
		
		return "forward:searchEmployeeForm";
	}
	
	@GetMapping("/cookiePage")
	public String dispalyCookiePage() {
		return "cookiePage";
	}
	
	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse resp,ModelMap modelMap) {
		Cookie cookie=new Cookie("companyName", "Capgemini");
		resp.addCookie(cookie);
		modelMap.addAttribute("msg", "cookie created"+cookie);
	
		return "cookiePage";
	}
	
	@GetMapping("/readCookie")
	public String readCookie(@CookieValue(name="companyName") String companyName ,ModelMap modelMap) {
		
		modelMap.addAttribute("msg", "cookie value is"+companyName);
	return "cookiePage";
	}
}
