package hrms.northwind.business.abstracts;

import hrms.northwind.entities.concretes.JobPosition;

public interface JobPositionCheckService {
	
	boolean isUniqueJobPosition(JobPosition jobPosition);

}
