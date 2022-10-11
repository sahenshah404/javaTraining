package one2one;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class One2oneMain { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
//		Person person = new Person();
//		person.setPersonName("zubin");
//		person.setPersonCity("banglore");
		
		Person person = manager.find(Person.class, 3);
		if(person == null)
			System.out.println("No such person found");
		else {
			
			transaction.begin();
		
		Passport passport = new Passport();
////		passport.setPassportId(101);
		passport.setIssueDate(new Date());
		passport.setExpiryDate(new Date());
//		
		passport.setPerson(person);
//		
		manager.persist(passport);
		transaction.commit();
		}
		manager.close();
		
	}

}
