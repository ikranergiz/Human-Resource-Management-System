package hrms.northwind.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getByIsActive(boolean isActive);
	Result addJobAdvertisement(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> findByCreationDateAndIsActive(LocalDate creationDate, boolean isActive);
	DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_CompanyName
	(boolean isActive, String companyName);
	
	Result updateIsActive(boolean isActive);
}
