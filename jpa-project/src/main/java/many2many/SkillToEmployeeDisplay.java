package many2many;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SkillToEmployeeDisplay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("from Skills");
		
		@SuppressWarnings("unchecked")
		List<Skills> skills = query.getResultList();
		
		for(Skills skill : skills) {
			System.out.print( skill.getSkillName() + " -  ");
				for (EmployeeSkills employeeSkill : skill.getEmployeeSkills()) {
					System.out.print(employeeSkill.getEmpname()+ " ");
			}
			System.out.println();
		}
		
		manager.close();
		
		
	}

}
