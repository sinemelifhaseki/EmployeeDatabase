package hello;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="jobtable")
public class JobTitleEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	private String title;
	private String description;
	boolean executive = false;
	@OneToMany(mappedBy = "jobtitle", cascade = CascadeType.ALL)
	private List<EmployeeEntity> employees;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isExecutive() {
		return executive;
	}
	public void setExecutive(boolean executive) {
		this.executive = executive;
	}
	
	public List<EmployeeEntity> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}
	
	
}
