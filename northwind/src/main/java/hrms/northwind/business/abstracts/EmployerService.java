package hrms.northwind.business.abstracts;

import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
}
