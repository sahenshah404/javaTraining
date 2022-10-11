package one2many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.Table;

//@Entity
//@Table(name = "customer")
public class Customer {
	@Id
	private int custid;
	@Column(length = 25)
	private String name;
	@Column(length = 25)
	private String citys;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	List<Account> accounts;
	
	public List<Account> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCitys() {
		return citys;
	}
	public void setCitys(String citys) {
		this.citys = citys;
	}
	


}
