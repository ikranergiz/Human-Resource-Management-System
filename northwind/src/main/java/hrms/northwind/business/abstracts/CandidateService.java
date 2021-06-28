package hrms.northwind.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.entities.concretes.Candidate;

public interface CandidateService{

	Result save(Candidate candidate) throws RemoteException;
	DataResult<List<Candidate>> getAll();
}
