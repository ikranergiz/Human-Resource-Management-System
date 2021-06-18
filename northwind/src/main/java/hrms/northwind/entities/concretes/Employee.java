package hrms.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@Entity

@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "employee_id") 

@Table(name = "employees")
public class Employee extends User{

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
}
