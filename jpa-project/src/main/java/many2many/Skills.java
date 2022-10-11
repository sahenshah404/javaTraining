package many2many;

import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
public class Skills {
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int skillId;
//	@Column
	@Id
	private String skillName;
	
	@ManyToMany(mappedBy = "skills", cascade = CascadeType.ALL)
	List<EmployeeSkills> employeeSkills;

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public List<EmployeeSkills> getEmployeeSkills() {
		return employeeSkills;
	}

	public void setEmployeeSkills(List<EmployeeSkills> employeeSkills) {
		this.employeeSkills = employeeSkills;
	}
	
	
	
}
