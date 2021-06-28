package hrms.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.EmployerCheckService;
import hrms.northwind.business.abstracts.EmployerService;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.ErrorResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.core.utilities.results.SuccessDataResult;
import hrms.northwind.core.utilities.results.SuccessResult;
import hrms.northwind.dataAccess.abstracts.EmployerDao;
import hrms.northwind.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmployerCheckService employerCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerCheckService employerCheckService) {
		super();
		this.employerDao = employerDao;
		this.employerCheckService = employerCheckService;
	}

	@Override
	public Result save(Employer employer) {
		
		if(!this.employerCheckService.isCompany(employer)) {
			return new ErrorResult("Domain mail ile uyumlu olmalıdır.");	
		}
		
		if(!this.employerCheckService.isConfirmedEmail(employer)) {
			return new ErrorResult("E-mail doğrulanmalıdır.");
		}
		
		if(!this.employerCheckService.isConfirmedHrms(employer)) {
			return new ErrorResult("Kayıt için HRMS personel onayı gereklidir.");
		}
		
		if(this.employerCheckService.isNull(employer)) {
			return new ErrorResult("Tüm alanların doldurulması zorunludur.");
		}
		
		if(!this.employerCheckService.isUniqueEmail(employer)) {
			return new ErrorResult("E-mail benzersiz olmalıdır");
		}
		
		this.employerDao.save(employer);
		return new SuccessResult("Employer eklendi");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(),"Employer listelendi");
	}

}
