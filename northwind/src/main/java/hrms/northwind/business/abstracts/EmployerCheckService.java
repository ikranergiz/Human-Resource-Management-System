package hrms.northwind.business.abstracts;

import hrms.northwind.entities.concretes.Employer;

public interface EmployerCheckService {

	boolean isCompany(Employer employer);
	boolean isNull(Employer employer);
	boolean isConfirmedEmail(Employer employer);
	boolean isConfirmedHrms(Employer employer);
	boolean isUniqueEmail(Employer employer);
}
