package many2manybankcust;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BankCustDisplay {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		
		Query query1 = manager.createQuery("from Bank");
		List<Bank> banks = query1.getResultList();
		
		for (Bank bank : banks) {
			System.out.println(bank.getBankid() + " " + bank.getBranchName()+ 
					" " + bank.getName() + " " + bank.getSwiftCode());
			Set<Customer> customers = bank.getCustomers();
			for (Customer customer : customers) {
				System.out.println(customer.getCustid() + " " +
						customer.getCustname() + " "+ customer.getBalance());
			}
		}
		
		System.out.println();
		// calling form customers
		Query query2 = manager.createQuery("from Customer");
		List<Customer> customers = query2.getResultList();
		
			for (Customer customer : customers) {
				System.out.println(customer.getCustid() + " " +
						customer.getCustname() + " "+ customer.getBalance());
			Set<Bank> banks2 = customer.getBanks();
			for (Bank bank : banks2) {
				System.out.println(bank.getBankid() + " " + bank.getBranchName()+ 
						" " + bank.getName() + " " + bank.getSwiftCode());
			}
		}
		
		
	}

}
