package hrms.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.CandidateCheckService;
import hrms.northwind.dataAccess.abstracts.CandidateDao;
import hrms.northwind.entities.concretes.Candidate;


@Service
public class CandidateCheckManager implements CandidateCheckService{

	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateCheckManager(CandidateDao candidateDao) {
		
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public boolean isNull(Candidate candidate) {
		
		if(candidate.getEmail().isEmpty() ||
				candidate.getFirstName().isEmpty() ||
				candidate.getIdentityNumber().isEmpty() ||
				candidate.getLastName().isEmpty() || 
				candidate.getPassword().isEmpty()||
				candidate.getYearOfbirth().isEmpty()){
			
			return true;
		}
		
		return false;
	}

	@Override
	public boolean findByEmailEquals(Candidate candidate) {
		
		if(this.candidateDao.findByEmailEquals(candidate.getEmail()) != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isConfirmedEmail(Candidate candidate) {
		return true;
	}

	@Override
	public boolean findByIdEquals(Candidate candidate) {
		
		if(this.candidateDao.findByIdentityNumberEquals(candidate.getIdentityNumber()) != null) {
			return true;
		}
		
		return false;
	}

	

	

	


}
