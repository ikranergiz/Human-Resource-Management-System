package hrms.northwind.business.abstracts;

import java.util.List;

import hrms.northwind.entities.concretes.JobPosition;

public interface JobPositionService {
	
	List<JobPosition> getAll();

}
