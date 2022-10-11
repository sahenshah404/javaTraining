package core;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentNamedQueries {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("medpluspu");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createNamedQuery("findAll");
		List<Student> students = query.getResultList();
		
		students.forEach((s)->System.out.println(s.getStudentId()+ " " + s.getStudentName()));
		
		Query query2 = manager.createNamedQuery("findById");
		query2.setParameter(1, 2);
		List<Student> students2 = query2.getResultList();
		
		students2.forEach((s)->System.out.println(s.getStudentId()+ " " + s.getStudentName()));
		
		
	}

}
