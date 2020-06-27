package com.jfsfeb.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jfsfeb.springmvc.dto.EmployeeBean;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

public EmployeeBean getEmployeeByid(int empId) {
	EmployeeBean employeeInfoBean = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		try {
Class.forName("com.mysql.jdbc.Driver");
			
			
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","j2ee","root");
			pstmt = connection.prepareStatement("select * from employee_info where empId=?");
			pstmt.setInt(1,empId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				employeeInfoBean = new EmployeeBean();
				employeeInfoBean.setEmpId(rs.getInt("empId"));
				employeeInfoBean.setAge(rs.getInt("age"));
				employeeInfoBean.setEmpName(rs.getString("empName"));
				employeeInfoBean.setDesignation(rs.getString("designation"));
				employeeInfoBean.setPassword(rs.getString("password"));
				employeeInfoBean.setSalary(rs.getDouble("salary"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		
	}
	
	return employeeInfoBean;
	}

	public boolean addEmployee(EmployeeBean bean) {
		
		String query1="insert into employee_info values(?,?,?,?,?,?)";
		
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","j2ee","root");
			
			PreparedStatement preparedStatement3= connection.prepareStatement(query1);
			
			
			preparedStatement3.setInt(1, bean.getEmpId());
			preparedStatement3.setString(2,bean.getEmpName());
			preparedStatement3.setInt(3, bean.getAge());
		    preparedStatement3.setDouble(4, bean.getSalary());
			preparedStatement3.setString(5, bean.getDesignation());
			preparedStatement3.setString(6, bean.getPassword());
			
			int result = preparedStatement3.executeUpdate();
			
			if(result!=0) {
	         System.out.println("values are inserted succefully");
	         return true;
			}
			
			connection.close();
			

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;
		
		
		
		
	}

	public boolean updateEmployee(EmployeeBean bean) {
		EmployeeBean emppbean = null;
		boolean isUpdated = false	;
		
		
			
	
				try{
					Class.forName("com.mysql.jdbc.Driver");
					
					
			        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","j2ee","root");
					PreparedStatement pstmt=connection.prepareStatement("update employee_info set empname=? where empid=? ");
				pstmt.setString(1,bean.getEmpName());
				pstmt.setInt(2, bean.getEmpId());
				
				int result = pstmt.executeUpdate();
				if(result>0) {
			         System.out.println("values are updated succefully");
			         isUpdated= true;
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			 
			
		
		
		return isUpdated;
	}

	public boolean deleteEmployee(int empId) {
		
		boolean isDeleted = false	;
		

			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				
		        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","j2ee","root");
		        PreparedStatement pstmt1 = connection.prepareStatement("delete from  employee_info  where empId=?");


				pstmt1.setInt(1, empId);

				int result = pstmt1.executeUpdate();
				if(result>0) {
					System.out.println("values deleted succefully");
					isDeleted= true;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		
		return isDeleted;
}

	public List<EmployeeBean> getAllEmployees() {
List<EmployeeBean>   listInfo=  new ArrayList<EmployeeBean>();

		
		ResultSet rs = null;

		
			try {
Class.forName("com.mysql.jdbc.Driver");
				
				
		        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","j2ee","root");
				PreparedStatement pstmt1 = connection.prepareStatement("select * from employee_info");
				rs = pstmt1.executeQuery();

				while(rs.next()) {
					EmployeeBean bean2 = new EmployeeBean();	

					bean2.setEmpName(rs.getString("empName"));
					bean2.setAge(rs.getInt("age"));
					bean2.setPassword(rs.getString("password"));
					bean2.setDesignation(rs.getString("designation"));
					bean2.setSalary(rs.getDouble("salary"));
					bean2.setEmpId(rs.getInt("empId"));

					listInfo.add(bean2);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(rs!=null) {
					try {
						rs.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}


				return listInfo;

	}

	public EmployeeBean authenticate(int empId, String password) {
		EmployeeBean employeeInfoBean = getEmployeeByid(empId);
		if(!(employeeInfoBean !=null && employeeInfoBean.getPassword().equals(password))) {
			  employeeInfoBean = null;
		}
		return null;
	}

		
	
	
}
