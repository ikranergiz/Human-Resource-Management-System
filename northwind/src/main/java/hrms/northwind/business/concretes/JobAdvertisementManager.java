package hrms.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.JobAdvertisementService;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.core.utilities.results.SuccessDataResult;
import hrms.northwind.core.utilities.results.SuccessResult;
import hrms.northwind.dataAccess.abstracts.JobAdvertisementDao;
import hrms.northwind.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive(boolean isActive) {

		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByIsActive(isActive), "iş ilanları listelendi!");
	}

	@Override
	public Result addJobAdvertisement(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("iş ilanı eklendi!");
	}

}
