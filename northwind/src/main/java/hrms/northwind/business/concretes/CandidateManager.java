package hrms.northwind.business.concretes;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.CandidateCheckService;
import hrms.northwind.business.abstracts.CandidateService;
import hrms.northwind.core.utilities.adapters.abstracts.MernisCheckService;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.ErrorResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.core.utilities.results.SuccessDataResult;
import hrms.northwind.core.utilities.results.SuccessResult;
import hrms.northwind.dataAccess.abstracts.CandidateDao;
import hrms.northwind.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private MernisCheckService mernisCheckService;
	private CandidateCheckService candidateCheckService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,
			MernisCheckService mernisCheckService,
			CandidateCheckService candidateCheckService) {
		super();
		this.mernisCheckService = mernisCheckService;
		this.candidateDao = candidateDao;
		this.candidateCheckService = candidateCheckService;
	}

	@Override
	public Result save(Candidate candidate) throws RemoteException {
		
		if(this.candidateCheckService.isNull(candidate))
			return new ErrorResult("Alanlar boş bırakılamaz");
		
		/*if(this.mernisCheckService.checkIfRealPerson(candidate))
			return new ErrorResult("Mernis Doğrulaması başarısız");*/
		
		if(this.candidateCheckService.findByEmailEquals(candidate)) {
			return new ErrorResult(candidate.getEmail() + " e-mail zaten kullanılıyor!");
		}
		
		if(this.candidateCheckService.findByIdEquals(candidate))
			return new ErrorResult("TC kimlik no benzersiz olmalıdır!");
		
		if(!this.candidateCheckService.isConfirmedEmail(candidate))
			return new ErrorResult("Kayıt için e-mail doğrulaması gereklidir.");
			
		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate eklendi");
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(),"Candidates Listelendi");
	}
	


}








