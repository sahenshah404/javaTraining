package elementColection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeSkAppl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		EmployeeSk employeeSk = new EmployeeSk();
		employeeSk.setEmpcode(102);
		employeeSk.setEmpname("bala");
		employeeSk.setSalary(60000);
		List<String> skills = new ArrayList<String>();
		skills.add("java");
		skills.add("python");
		skills.add("react");
		skills.add("node");
		employeeSk.setSkills(skills);
		
		transaction.begin();
		manager.persist(employeeSk);
		transaction.commit();
		manager.close();
		
		
	}

}
