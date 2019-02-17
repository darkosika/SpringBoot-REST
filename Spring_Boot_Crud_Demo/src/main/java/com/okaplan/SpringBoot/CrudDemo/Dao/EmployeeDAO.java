package com.okaplan.SpringBoot.CrudDemo.Dao;

import java.util.List;

import com.okaplan.SpringBoot.CrudDemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findByid(int id);
	
	public void save(Employee employee);
	
	public void deleteByid(int id);
	}
