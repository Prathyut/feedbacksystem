package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Admin;
import com.klef.ep.models.EmpGrievance;
import com.klef.ep.models.Employee;
import com.klef.ep.models.HRSE;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class HRServiceImpl implements HRService
{
	@Override
	  public String addGrievance(EmpGrievance gre) 
	  {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
	    em.getTransaction().begin();
	    em.persist(gre); 
	    em.getTransaction().commit();
	    
	    em.close();
	    emf.close();
	    
	    return "Grievance Submited Successfully";
	  }

	public List<EmpGrievance> viewallgre() 
	  {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
	    Query qry = em.createQuery("select e from EmpGrievance e");
	    List<EmpGrievance> grelist = qry.getResultList();
	    
	      em.close();
	      emf.close();
	      
	      return grelist;
	  }
	  
	  @Override
	  public List<EmpGrievance> mygre() {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	        EntityManager em = emf.createEntityManager();
	        
	        try {
	            FacesContext facesContext = FacesContext.getCurrentInstance();
	            Employee emp = (Employee) facesContext.getExternalContext().getSessionMap().get("emps");
	            String fullname = emp.getFullname();

	            Query qry = em.createQuery("SELECT e FROM EmpGrievance e WHERE e.ticket_raiser = :fullname");
	            qry.setParameter("fullname", fullname);
	            
	            List<EmpGrievance> grelist = qry.getResultList();
	            
	            return grelist;
	        } finally {
	            em.close();
	            emf.close();
	        }
	    }

	@Override
	public String deletegre(int ticket_id) {
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	  EntityManager em = emf.createEntityManager();
	  
	  em.getTransaction().begin();
	  
	  EmpGrievance e = em.find(EmpGrievance.class, ticket_id);
	  em.remove(e);
	  em.getTransaction().commit();
	  
	  em.close();
	  emf.close();
	  
	  return "Grievance Deleted Successfully";
	}

	@Override
	public String updategrestatus(EmpGrievance gre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
	    em.getTransaction().begin();
	    
	    EmpGrievance e = em.find(EmpGrievance.class, gre.getTicket_id());
	    
	        e.setTicket_id(gre.getTicket_id());
	        e.setTicket_raiser(gre.getTicket_raiser());
	        e.setResponsiblePerson(gre.getResponsiblePerson());
	        e.setGre_status(gre.getGre_status());

	    
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
	    
	    return "Grevance Status Updated Successfully";
	}

	@Override
	public EmpGrievance viewgrebyid(int ticket_id) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
	     EmpGrievance e = em.find(EmpGrievance.class, ticket_id);
	    
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
	  public HRSE checkhrlogin(String username, String password) 
	  {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
	    // h is an alias of HR Class
	    Query qry = em.createQuery("select h from HRSE h where h.username=? and h.password=?  ");
	    qry.setParameter(1, username);
	    qry.setParameter(2, password);
	    
	        HRSE hrs = null;
	        
	        if(qry.getResultList().size()>0)
	        {
	          hrs = (HRSE) qry.getSingleResult();
	        }
	    em.close();
	    emf.close();
	    
	    return hrs;
	  }

}
