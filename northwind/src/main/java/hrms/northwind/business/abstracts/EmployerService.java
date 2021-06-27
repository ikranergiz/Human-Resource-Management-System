package hrms.northwind.business.abstracts;

import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.entities.concretes.Employer;

public interface EmployerService{

	public Result save(Employer employer);
	public DataResult<List<Employer>> getAll();
}
