package com.okaplan.SpringBoot.CrudDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.okaplan.SpringBoot.CrudDemo.Dao.EmployeeDAO;
import com.okaplan.SpringBoot.CrudDemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl( EmployeeDAO theEmployeeDAO) {
		employeeDAO=theEmployeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findByid(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.findByid(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteByid(int id) {
		// TODO Auto-generated method stub
		employeeDAO.deleteByid(id);
	}

}
