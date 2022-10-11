package many2many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeSkillSelection {

	public static void main(String[] args) {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		EmployeeSkills employeeSkills = manager.find(EmployeeSkills.class, 3);
		Skills skill = manager.find(Skills.class, "java");
		Skills skill2 = manager.find(Skills.class, "spring");
		
		employeeSkills.skills.add(skill);
		employeeSkills.skills.add(skill2);
		
		transaction.begin();
		manager.persist(employeeSkills);
		transaction.commit();
		manager.close();

	}

}
