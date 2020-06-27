package com.jfsfeb.springmvc.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@SuppressWarnings("serial")
@Data
public class PersonBean implements Serializable {
	private String name;
	private Date dob;

}
