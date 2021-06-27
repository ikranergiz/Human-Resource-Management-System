package hrms.northwind.core.utilities.adapters.concretes;


import java.rmi.RemoteException;

import hrms.northwind.core.utilities.adapters.abstracts.MernisCheckService;
import hrms.northwind.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisCheckManagerAdapter implements MernisCheckService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) throws RemoteException {
		
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		
		boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(
		            Long.parseLong(candidate.getIdentityNumber().toUpperCase()),
			        candidate.getFirstName().toUpperCase(),
		            candidate.getLastName().toUpperCase(),
		            candidate.getYearOfbirth() // Doğum Yılı
		            );
		
		return result;
	}

}
