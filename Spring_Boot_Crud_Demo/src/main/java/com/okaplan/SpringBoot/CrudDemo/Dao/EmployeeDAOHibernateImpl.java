package com.okaplan.SpringBoot.CrudDemo.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.okaplan.SpringBoot.CrudDemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//define field Entity Manager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	@Override
	public List<Employee> findAll() {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//create query
		Query<Employee> theQuery=currentSession.createQuery("from Employee",Employee.class);
		//execute query and get result list
		List<Employee> employees=theQuery.getResultList();
		//return the results
		return employees;
	}
	@Override
	public Employee findByid(int id) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//get Employee
		Employee employee=currentSession.get(Employee.class, id);
		
		return employee;
	}
	@Override
	public void save(Employee employee) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(employee);
		
	}
	@Override
	public void deleteByid(int id) {
		//get the current hibernate session
	     Session currentSession = entityManager.unwrap(Session.class);
	     //delete object with primary key
	     Query thequery=currentSession.createQuery("Delete from Employee where id=:employeeId");
	     thequery.setParameter("employeeId", id);
	     thequery.executeUpdate();
		
	}

}
