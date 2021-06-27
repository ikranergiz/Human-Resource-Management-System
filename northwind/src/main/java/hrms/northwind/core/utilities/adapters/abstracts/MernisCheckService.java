package hrms.northwind.core.utilities.adapters.abstracts;

import java.rmi.RemoteException;

import hrms.northwind.entities.concretes.Candidate;

public interface MernisCheckService {

	public boolean checkIfRealPerson(Candidate candidate) throws RemoteException;
}
