package hrms.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Data
@Table(name = "job_experiences")
public class JobExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_experience_id")
	private int id;
	
	@Column(name = "company_name")
	private String companyName;
	
	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
	
	@Column(name = "start_year")
	private String startYear;
	
	@Column(name = "quit_year")
	private String quitYear;
	
	@OneToMany(mappedBy = "jobExperience")
	private CV cv;
}
