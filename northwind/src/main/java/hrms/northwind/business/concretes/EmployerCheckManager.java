package hrms.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.EmployerCheckService;
import hrms.northwind.dataAccess.abstracts.EmployerDao;
import hrms.northwind.entities.concretes.Employer;

@Service
public class EmployerCheckManager implements EmployerCheckService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerCheckManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public boolean isCompany(Employer employer) {

		String domain = employer.getEmail().substring(
				employer.getEmail().indexOf("@") + 1, 
				employer.getEmail().indexOf("."));

		if(employer.getCompanyName().equals(domain)) {
			return true;
		}
			
		return false;
	}

	@Override
	public boolean isNull(Employer employer) {
		
		if(employer.getCompanyName().isEmpty() ||
			employer.getEmail().isEmpty() ||
			employer.getPassword().isEmpty() ||
			employer.getPhoneNumber().isEmpty() ||
			employer.getWebSite().isEmpty() ) {
			
			return true;
		}
			
		return false;
	}

	@Override
	public boolean isConfirmedEmail(Employer employer) {
		return true;
	}

	@Override
	public boolean isConfirmedHrms(Employer employer) {
		return true;
	}

	@Override
	public boolean isUniqueEmail(Employer employer) {
		
		if(this.employerDao.findByEmailEquals(employer.getEmail()) != null) {
			return false;
		}
		
		return true;
	}

}
