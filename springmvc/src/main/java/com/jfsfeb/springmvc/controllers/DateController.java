package com.jfsfeb.springmvc.controllers;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.jfsfeb.springmvc.dto.PersonBean;

@Controller
public class DateController {
	@GetMapping("/personDetails")
	public String dispalyPersonPage() {
		return "personDetails";
		
	}
	
	@PostMapping("/submitPerson")
public String submitPerson(PersonBean personean,ModelMap modelMap) {
		
		modelMap.addAttribute("person", personean);
		return "personDetails";
	}	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	}

}
