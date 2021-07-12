package hrms.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor

@Data
@Entity
@Table(name = "CVs")
public class CV {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CV_id")
	private int CVid;
	
	@ManyToOne()
	@JoinColumn(name = "university_id")
	private List<University> university;
	
	@ManyToOne()
	@JoinColumn(name = "job_experience_id")
	private JobExperience jobExperience;
	
	private ForeignLanguage foreignLanguage;
	
	private ProgrammingLanguage programmingLanguages;
	
	private Technology technologies;
	
	

}
