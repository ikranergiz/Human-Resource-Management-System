package hrms.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.JobPositionCheckService;
import hrms.northwind.business.abstracts.JobPositionService;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.ErrorResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.core.utilities.results.SuccessDataResult;
import hrms.northwind.core.utilities.results.SuccessResult;
import hrms.northwind.dataAccess.abstracts.JobPositionDao;
import hrms.northwind.entities.concretes.JobPosition;

@Service //bu business katmanıdır.
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	private JobPositionCheckService jobPositionCheckService;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao, JobPositionCheckService jobPositionCheckService) {
		super();
		this.jobPositionDao = jobPositionDao;
		this.jobPositionCheckService = jobPositionCheckService;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		
		if(!this.jobPositionCheckService.isUniqueJobPosition(jobPosition)) {
			return new ErrorResult(jobPosition.getJobPosition() 
					+ " zaten mevcut.");
		}
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult(jobPosition.getJobPosition() + " eklendi");
	}

}
