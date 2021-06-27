package hrms.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.UserService;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.core.utilities.results.SuccessDataResult;
import hrms.northwind.core.utilities.results.SuccessResult;
import hrms.northwind.dataAccess.abstracts.UserDao;
import hrms.northwind.entities.concretes.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result save(User user) {
		
		this.userDao.save(user);
		return new SuccessResult("User veritabanına eklendi");
	}

	@Override
	public DataResult<List<User>> getAll() {
	
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll(),"Users listelendi");
	}

}
