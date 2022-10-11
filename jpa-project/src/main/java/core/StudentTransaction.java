package core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentTransaction {
	
	private EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("medpluspu");

	public void insertStudent(Student student) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(student);
		
		transaction.commit();
		manager.close();
	
	}

	public void removeStudent(int studid) {

			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			Student student = manager.find(Student.class, studid);
			
			transaction.begin();
			manager.remove(student);
			
			transaction.commit();
			manager.close();
		
	}
	
}
