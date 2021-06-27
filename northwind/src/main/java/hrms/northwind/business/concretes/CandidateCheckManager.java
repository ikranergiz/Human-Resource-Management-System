package hrms.northwind.business.concretes;

import hrms.northwind.business.abstracts.CandidateCheckService;
import hrms.northwind.core.utilities.adapters.abstracts.MernisCheckService;
import hrms.northwind.entities.concretes.Candidate;

public class CandidateCheckManager implements CandidateCheckService{


	@Override
	public boolean isNull(Candidate candidate) {
		
		if(candidate.getFirstName().isEmpty() || 
				candidate.getLastName().isEmpty() || 
				candidate.getEmail().isEmpty() || 
				candidate.getIdentityNumber().isEmpty()) {
			
			return false;
		}
		return true;
	}

	@Override
	public boolean isUnique(Candidate candidate) {
	
		return false;
	}

}
