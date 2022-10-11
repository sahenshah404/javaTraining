package one2many;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class One2ManyDisplay {

	public static void main(String[] args) {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("from Customer");
		@SuppressWarnings("unchecked")
		List<Customer> customers = query.getResultList();
		
		System.out.println();
		System.out.println("custId \t name \t city \t\t accounts");
		
		for (Customer customer : customers) {
			System.out.println(customer.getCustid()+ "\t" +
							customer.getName() + "\t" +
							customer.getCitys() + "\t accountList");
			for (Account account : customer.getAccounts()) {
				System.out.println("\t\t\t\t "+ account.getAcno());
			}
			System.out.println();
		}
		
		manager.close();


	}

}
