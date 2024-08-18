package com.klef.ep.services;

import java.util.List;


import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Employee;


@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class EmployeeServiceImpl implements EmployeeService
{
  @Override
  public String addemployee(Employee employee) 
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
    
    em.getTransaction().begin();
    em.persist(employee); 
    em.getTransaction().commit();
    
    em.close();
    emf.close();
    
    return "Employee Registered Successfully";
  }
  
  @Override
	public Employee checkemplogin(String email, String password) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		// e is an alias of Employee Class
		Query qry = em.createQuery("select e from Employee e where e.email=? and e.password=?");
		qry.setParameter(1, email);
		qry.setParameter(2, password);
		
		Employee emp=null;
		if(qry.getResultList().size()>0)
		{
			emp = (Employee) qry.getSingleResult(); //gives single result
		}
		em.close();
		emf.close();
		
		
		return emp;
	}

@Override
public List<Employee> viewallemps()
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
    
    Query qry = em.createQuery("select e from Employee e");
    // e is an alias of Employee Class
    List<Employee> emplist = qry.getResultList();
    
      em.close();
      emf.close();
      
      return emplist;
}

@Override
public String deleteemployee(int id) 
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
    
    em.getTransaction().begin();
    
    Employee e = em.find(Employee.class, id);
    em.remove(e);
    em.getTransaction().commit();
    
    em.close();
    emf.close();
    
    return "Employee Deleted Successfully";
	
}

@Override
public Employee viewempbyid(int id) {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
    
  Employee e = em.find(Employee.class, id);
    
    if(e==null)
    {
      em.close();
      emf.close();
      return null;
    }
    
    em.close();
    emf.close();
    
    return e;
}

@Override
public String updateallemp(Employee emp) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
    
    em.getTransaction().begin();
    
    Employee e = em.find(Employee.class, emp.getId());
    
    
    e.setId(emp.getId());
      e.setFullname(emp.getFullname());
      e.setEmail(emp.getEmail());
      e.setGender(emp.getGender());
      e.setMarital_status(emp.getMarital_status());
      e.setContactno(emp.getContactno());
      e.setSalary(emp.getSalary());
      e.setStatus(emp.getStatus());
      

    
    em.getTransaction().commit();
    em.close();
    emf.close();
    
    return "Employee Updated Successfully";
}

@Override
public String updatepwd(Employee employee) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
    
    em.getTransaction().begin();
    
    Employee e = em.find(Employee.class, employee.getId());
    
    
        e.setPassword(employee.getPassword());

    
    em.getTransaction().commit();
    em.close();
    emf.close();
    
    return "Password Updated Successfully";
}

}