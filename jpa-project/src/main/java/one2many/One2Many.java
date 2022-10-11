package one2many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class One2Many {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Customer customer = new Customer();
		customer.setCustid(102);
		customer.setName("sandeep");
		customer.setCitys("pondi");
		
		List<Account>  accounts = new ArrayList<Account>();
		Account account = new Account();
		account.setAcno(1004);
		account.setType("savings");
		account.setBalance(10000);
		account.setCustomer(customer);
		
		Account account2 = new Account();
		account2.setAcno(1005);
		account2.setBalance(30000);
		account2.setType("savings");
		account2.setCustomer(customer);
		
		accounts.add(account);
		accounts.add(account2);
		
		customer.setAccounts(accounts);
		
		transaction.begin();
		manager.persist(customer);
		transaction.commit();
		manager.close();

	}

}
