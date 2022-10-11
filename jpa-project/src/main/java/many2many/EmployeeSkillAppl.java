package many2many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeSkillAppl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		EmployeeSkills employeeSkills = new EmployeeSkills();
		employeeSkills.setEmpname("vinay");
		List<Skills> skills = new ArrayList<Skills>();
		List<EmployeeSkills> empSkills = new ArrayList<EmployeeSkills>();
		
		Skills skill = new Skills();
		skill.setSkillName("java");
		
		Skills skill2 = new Skills();
		skill2.setSkillName("python");
		
		skills.add(skill);
		skills.add(skill2);
		
		employeeSkills.setSkills(skills);

		skill.setEmployeeSkills(empSkills);
		skill2.setEmployeeSkills(empSkills);
		
		
		
		
		transaction.begin();
		manager.persist(employeeSkills);
		transaction.commit();
		manager.close();

	}

}
