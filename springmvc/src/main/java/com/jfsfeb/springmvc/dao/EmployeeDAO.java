package com.jfsfeb.springmvc.dao;



import java.util.List;

import com.jfsfeb.springmvc.dto.EmployeeBean;

public interface EmployeeDAO {
	public EmployeeBean getEmployeeByid(int Id);
	public boolean addEmployee(EmployeeBean bean);
	public boolean updateEmployee(EmployeeBean bean);
	public boolean deleteEmployee(int Id);
	public List<EmployeeBean> getAllEmployees();
	public EmployeeBean authenticate(int empId,String password);
}
