package hrms.northwind.business.abstracts;

import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.entities.concretes.User;

public interface UserService {

	public Result save(User user);
	public DataResult<List<User>> getAll();
}
