package core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeAppl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Employee employee = new Employee();
		employee.setEmpcode(101);
		employee.setEmpname("viany");
		employee.setSalary(50000);
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
		manager.close();
	}

}
