package hrms.northwind.business.abstracts;

import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.entities.concretes.JobPosition;

public interface JobPositionService {
	
	DataResult<List<JobPosition>> getAll();

}
