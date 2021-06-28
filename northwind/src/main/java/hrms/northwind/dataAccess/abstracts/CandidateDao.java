package hrms.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.northwind.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{

	Candidate findByEmailEquals(String email);
	Candidate findByIdentityNumberEquals(String identityNumber);
}
