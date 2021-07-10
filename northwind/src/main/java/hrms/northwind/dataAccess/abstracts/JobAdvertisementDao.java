package hrms.northwind.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.northwind.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	List<JobAdvertisement> getByIsActive(boolean isActive);
	List<JobAdvertisement> findByCreationDateAndIsActive(LocalDate creationDate ,boolean isActive);
	List<JobAdvertisement> getByIsActiveAndEmployer_CompanyName
	(boolean isActive, String companyName);

}
