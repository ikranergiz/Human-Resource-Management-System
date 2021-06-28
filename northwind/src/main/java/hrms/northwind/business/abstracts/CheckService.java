package hrms.northwind.business.abstracts;

import hrms.northwind.entities.concretes.User;

public interface CheckService {

	boolean isNullEmail(User user);
	boolean isNullPassword(User user);
	boolean isUniqueEmail(User user);
}
