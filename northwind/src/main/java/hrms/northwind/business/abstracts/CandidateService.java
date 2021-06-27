package hrms.northwind.business.abstracts;

import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.entities.concretes.Candidate;

public interface CandidateService{

	public Result save(Candidate candidate);
	public DataResult<List<Candidate>> getAll();
	
}
