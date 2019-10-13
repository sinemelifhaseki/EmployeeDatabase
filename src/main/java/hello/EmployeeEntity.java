package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employeetable")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idemployeetable")
	private long id;
	private String name;
	private String surname;
	private int age;
	private int income;
	@ManyToOne
    @JoinColumn(name = "jobtitleid")
	private JobTitleEntity jobtitle;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}
	

	public JobTitleEntity getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(JobTitleEntity jobtitle) {
		this.jobtitle = jobtitle;
	}

	
	
	

	
	
	
	
	

}
