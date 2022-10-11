package core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeCrud {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
//		Employee emp = manager.find(Employee.class, 101);
//		System.out.println(emp.getEmpcode() + " " +
//					 emp.getEmpname() + " " + emp.getSalary());
		
		transaction.begin();
		Employee emp = new Employee();
		
		emp.setEmpcode(102);
		emp.setEmpname("sai");
		emp.setSalary(40000);
//		emp = manager.merge(emp);
		
	manager.persist(emp);
//	manager.remove(emp);
	transaction.commit();
	manager.close();
	}

}
