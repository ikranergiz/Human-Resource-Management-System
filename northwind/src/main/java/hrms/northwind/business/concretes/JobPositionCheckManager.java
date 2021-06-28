package hrms.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.JobPositionCheckService;
import hrms.northwind.dataAccess.abstracts.JobPositionDao;
import hrms.northwind.entities.concretes.JobPosition;

@Service
public class JobPositionCheckManager implements JobPositionCheckService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionCheckManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public boolean isUniqueJobPosition(JobPosition jobPosition) {
		
		if(this.jobPositionDao.findByJobPositionEquals(jobPosition.getJobPosition()) != null) {
			return false;
		}
		return true;
	}

}
