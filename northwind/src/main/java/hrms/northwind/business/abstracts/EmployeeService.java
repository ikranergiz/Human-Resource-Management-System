package hrms.northwind.business.abstracts;

import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.entities.concretes.Employee;

public interface EmployeeService {

	DataResult<List<Employee>> getAll();
	Result add(Employee employee);
}
