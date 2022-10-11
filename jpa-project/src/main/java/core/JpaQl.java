package core;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class JpaQl {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		
		Employee emp = manager.find(Employee.class, 101);
		System.out.println(emp.getEmpcode()+ " " + emp.getEmpname());
		
		// To get All Object
		Query query = manager.createQuery("from Employee");
		List<Employee> employees = query.getResultList();
		employees.forEach((e)->System.out.println(e.getEmpcode()+ " "+e.getEmpname()));
		
		//To get objects based on conditions
		String queryString = "select emp from Employee emp where emp.empcode > ?";
		Query query2 = manager.createQuery(queryString);
		query2.setParameter(1, 102);
		List<Employee> employees2 = query2.getResultList();
		employees2.forEach((e)->System.out.println(e.getEmpcode()+ " "+e.getEmpname()));
		
		String queryString2 = "select emp from Employee emp where emp.empname like ?";
		Query query3 = manager.createQuery(queryString2);
		query3.setParameter(1, "%s%");
		List<Employee> employees3 = query3.getResultList();
		employees3.forEach((e)->System.out.println(e.getEmpcode()+ " "+e.getEmpname()));
		
		
		
	}

}
