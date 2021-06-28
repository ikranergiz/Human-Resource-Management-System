package hrms.northwind.business.abstracts;

import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.entities.concretes.Employer;

public interface EmployerService{

	Result save(Employer employer);
	DataResult<List<Employer>> getAll();
	
	
}
