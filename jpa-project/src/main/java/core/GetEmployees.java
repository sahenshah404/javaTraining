package core;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class GetEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("from Employee");
		@SuppressWarnings("unchecked")
		List<Employee> employees = query.getResultList();
		for (Employee emp : employees) {
			System.out.println(emp.getEmpcode() + " " +
					 emp.getEmpname() + " " + emp.getSalary());
		
		}
	}

}
