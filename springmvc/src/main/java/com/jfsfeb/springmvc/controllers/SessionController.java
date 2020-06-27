package com.jfsfeb.springmvc.controllers;

import javax.jws.WebParam.Mode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jfsfeb.springmvc.dto.EmployeeBean;
import com.jfsfeb.springmvc.service.EmployeeService;

import lombok.experimental.Accessors;

//@Controller
public class SessionController {

	@Autowired
	private EmployeeService service;

	
	@GetMapping("./loginForm")
	public String showLoginForm() {
		
		return "loginForm";
	}
	
	@PostMapping
	public String login(int empId,String password,ModelMap map,HttpServletRequest request){

		EmployeeBean employeeInfoBean= service.authenticate(empId, password);

		if(employeeInfoBean!= null) {
			HttpSession session=request.getSession();
			session.setAttribute("employeeLoggedInfo", employeeInfoBean);
			return "userHome";
		}else {
			map.addAttribute("errMsg","invaild credentials");
			return "loginForm";
		}
//		return null;
	}
	
	
	

	@GetMapping("/serchEmployeeForm")
	public String displaySearchEmployeeForm(HttpServletRequest request,ModelMap map) {
		
		HttpSession session=request.getSession(false);
		if(session!= null) {
			
			
			return "searchEmployee";
			//validSession
		}else {
			map.addAttribute("errMsg","pls login first");
			return "loginForm";
			//invaildSession
		}

	}
	
	
	@PostMapping("/addEmployeeForm")
	public String displayAddEmployeeForm(HttpSession session,ModelMap map) {
		
		if(session.isNew()) {
			session.invalidate();
			map.addAttribute("errMsg","pls login first");
			return "loginForm";
			//invaildSession
		}else {
			
			return "addEmployee";
			//vaild sesion
		}
	}
		

	
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session,ModelMap map) {
		
		
		session.invalidate();
		map.addAttribute("errMsg","you are suuceefully loggedout !!");
		
		return "loginForm";
	}
}
