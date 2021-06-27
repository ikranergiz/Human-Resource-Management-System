package hrms.northwind.business.abstracts;

import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.entities.concretes.Employee;

public interface EmployeeService {
	
	public Result save(Employee employee);
	public DataResult<List<Employee>> getAll();
}
