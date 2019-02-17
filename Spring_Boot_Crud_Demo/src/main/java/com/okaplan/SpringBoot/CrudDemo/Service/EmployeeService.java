package com.okaplan.SpringBoot.CrudDemo.Service;

import java.util.List;

import com.okaplan.SpringBoot.CrudDemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findByid(int id);
	
	public void save(Employee employee);
	
	public void deleteByid(int id);
}
