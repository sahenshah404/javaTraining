package many2many;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class EmployeeSkillDisplay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("from EmployeeSkills");
		
		@SuppressWarnings("unchecked")
		List<EmployeeSkills> employeeSkills = query.getResultList();
		
		for (EmployeeSkills employeeSkill : employeeSkills) {
			System.out.print( employeeSkill.getEmpname() + " - ");
			for(Skills skill : employeeSkill.getSkills()) {
				System.out.print(skill.getSkillName()+ " ");
			}
			System.out.println();
		}
		
		manager.close();
	}

}
