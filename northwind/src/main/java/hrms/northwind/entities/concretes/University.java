package hrms.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor

@Data
@Entity
@Table(name = "universities")
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "university_id")
	private int universityId;
	
	@NotNull
	@NotBlank
	@Column(name = "university_name")
	private String universityName;
	
	@NotNull
	@NotBlank
	@Column(name = "entrance_year")
	private String entranceYear;
	
	@Nullable
	@Column(name = "graduation_year")
	private String graduationYear;
	
	@OneToMany(mappedBy = "university")
	private List<UniversityDepartment> universityDepartment;
	
	@OneToMany(mappedBy = "university")
	private CV cv;
}
