package hrms.northwind.business.abstracts;

import hrms.northwind.entities.concretes.Candidate;

public interface CandidateCheckService {

	public boolean isNull(Candidate candidate);
	public boolean isUnique(Candidate candidate);
}
