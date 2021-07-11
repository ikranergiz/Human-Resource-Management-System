package hrms.northwind.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.JobAdvertisementService;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.ErrorResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.core.utilities.results.SuccessDataResult;
import hrms.northwind.core.utilities.results.SuccessResult;
import hrms.northwind.dataAccess.abstracts.JobAdvertisementDao;
import hrms.northwind.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActive(boolean isActive) {

		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActive(isActive), "iş ilanları listelendi!");
	}

	@Override
	public Result addJobAdvertisement(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("iş ilanı eklendi!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByCreationDateAndIsActive(LocalDate creationDate ,boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByCreationDateAndIsActive(creationDate,isActive), "Aktif iş ilanları tarihe göre listelendi!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_CompanyName
	(boolean isActive, String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByIsActiveAndEmployer_CompanyName
				(isActive, companyName), "Şirkete göre aktif ilanlar listelendi!");
	}

	@Override
	public Result updateIsActive(int jobAdvertisementId, boolean isActive) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(jobAdvertisementId);
		if(jobAdvertisement != null) {
			jobAdvertisement.setActive(isActive);
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("İş ilanı aktifliği başarıyla değiştirildi! " + isActive);
		}
		
		return new ErrorResult("Böyle bir ilan bulunamadı!");
	}


}
