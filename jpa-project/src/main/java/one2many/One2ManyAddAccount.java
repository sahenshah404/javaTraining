package one2many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class One2ManyAddAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		
		Account account = new Account();
		account.setAcno(1003);
		account.setType("savings");
		account.setBalance(20000);
		
		transaction.begin();
		Customer customer = manager.find(Customer.class, 101);
		account.setCustomer(customer);
		customer.getAccounts().add(account);
		
		manager.persist(customer);
		transaction.commit();
		manager.close();
		
	}

}
