package many2manybankcust;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BankCustCreateAppl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Bank bank1 = new Bank();
		bank1.setName("SBI");
		bank1.setBranchName("hyderabad");
		bank1.setSwiftCode("SBIHYD1");
		
		Bank bank2= new Bank();
		bank2.setName("SBI");
		bank2.setBranchName("banglore");
		bank2.setSwiftCode("SBIBNG1");
		
		Set<Bank> banks = new HashSet<Bank>();
		banks.add(bank1);
		banks.add(bank2);
		
		Customer customer1 = new Customer();
		customer1.setCustname("vinay");
		customer1.setBalance(10000);
		
		Customer customer2 = new Customer();
		customer2.setCustname("sandeep");
		customer2.setBalance(12000);
		
		Customer customer3 = new Customer();
		customer3.setCustname("bala");
		customer3.setBalance(13000);
		
		Customer customer4 = new Customer();
		customer4.setCustname("krishna");
		customer4.setBalance(14000);
		
		Set<Customer> customers1 = new HashSet<Customer>();
		customers1.add(customer1);
		customers1.add(customer2);
		customers1.add(customer3);
		
		Set<Customer> customers2 = new HashSet<Customer>();
		customers2.add(customer2);
		customers2.add(customer3);
		customers2.add(customer4);
		
		bank1.setCustomers(customers1);
		bank2.setCustomers(customers2);
		
		
		transaction.begin();
		manager.persist(bank1);
		manager.persist(bank2);
		transaction.commit();
		manager.close();

	}

}
