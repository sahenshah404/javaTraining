package one2one;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class One2oneRetrieve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("from Passport");
		
		@SuppressWarnings("unchecked")
		List<Passport> passports = query.getResultList();

		for (Passport passport : passports) {
			System.out.println(passport.getPassportId()+ " " +
					passport.getIssueDate() +  " " + 
					passport.getPerson().getPersonName() + " "
					+ passport.getPerson().getPersonCity());
		}
		
		manager.close();

	}

}
