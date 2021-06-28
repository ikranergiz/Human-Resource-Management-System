package hrms.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.CheckService;
import hrms.northwind.dataAccess.abstracts.UserDao;
import hrms.northwind.entities.concretes.User;

@Service
public class CheckManager implements CheckService{

	private UserDao userDao;
	
	@Autowired
	public CheckManager(UserDao userDao) {
		
		super();
		this.userDao = userDao;
	}

	@Override
	public boolean isNullEmail(User user) {
		
		if(user.getEmail().isEmpty() ) {
			
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isNullPassword(User user) {
		
		if(user.getPassword().isEmpty() ) {
			
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isUniqueEmail(User user) {
		
		if(this.userDao.findByEmail(user.getEmail()) != null) {
			
			return false;
		}
		
		return true;
	}

	

}
