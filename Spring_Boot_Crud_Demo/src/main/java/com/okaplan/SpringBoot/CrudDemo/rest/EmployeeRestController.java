package com.okaplan.SpringBoot.CrudDemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.okaplan.SpringBoot.CrudDemo.Dao.EmployeeDAO;
import com.okaplan.SpringBoot.CrudDemo.Service.EmployeeService;
import com.okaplan.SpringBoot.CrudDemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController( EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employess/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee=employeeService.findByid(employeeId);
		if(employee==null) {
			throw new RuntimeException("Employee id not found-"+employeeId);
			}
		return employee;
	}
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		//force save
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return 	theEmployee;
		}
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		return 	theEmployee;
		}
	@DeleteMapping("/employess/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee=employeeService.findByid(employeeId);
		if(employee==null) {
			throw new RuntimeException("Employee id not found-"+employeeId);
			}
		employeeService.deleteByid(employeeId);
		return	"Deleted Employee Id -"+employeeId;
				}
}
