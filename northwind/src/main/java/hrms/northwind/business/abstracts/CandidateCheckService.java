package hrms.northwind.business.abstracts;

import hrms.northwind.entities.concretes.Candidate;

public interface CandidateCheckService {

	boolean isNull(Candidate candidate);
	boolean findByIdEquals(Candidate candidate);
	boolean findByEmailEquals(Candidate candidate);
	boolean isConfirmedEmail(Candidate candidate);
}
