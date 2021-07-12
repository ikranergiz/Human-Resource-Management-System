package hrms.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor

@Data
@Entity
@Table(name = "technologies")
public class Technology {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "technology_id")
	private int technologyId;
	
	@Column(name = "technology")
	private String technology;
}
