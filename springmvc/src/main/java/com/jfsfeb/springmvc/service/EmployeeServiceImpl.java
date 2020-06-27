package com.jfsfeb.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jfsfeb.springmvc.dao.EmployeeDAO;
import com.jfsfeb.springmvc.dao.EmployeeDAOImpl;
import com.jfsfeb.springmvc.dto.EmployeeBean;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDAO empdao;

	public EmployeeBean getEmployeeByid(int Id) {

		return empdao.getEmployeeByid(Id);
	}

	public boolean addEmployee(EmployeeBean bean) {

		return empdao.addEmployee(bean);
	}

	public boolean updateEmployee(EmployeeBean bean) {

		return empdao.updateEmployee(bean);
	}

	public boolean deleteEmployee(int Id) {

		return empdao.deleteEmployee(Id);
	}

	public List<EmployeeBean> getAllEmployees() {
		return null;
	}

	public EmployeeBean authenticate(int empId, String password) {

		return empdao.authenticate(empId, password);
	}

}
