package hrms.northwind.business.abstracts;

import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getByIsActive(boolean isActive);
	Result addJobAdvertisement(JobAdvertisement jobAdvertisement);
	
}
