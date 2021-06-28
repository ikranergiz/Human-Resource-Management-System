package hrms.northwind.core.utilities.adapters.concretes;


import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import hrms.northwind.core.utilities.adapters.abstracts.MernisCheckService;
import hrms.northwind.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckManagerAdapter implements MernisCheckService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) throws RemoteException {
		
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		
		boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(
		            Long.parseLong(candidate.getIdentityNumber().toUpperCase()),
			        candidate.getFirstName().toUpperCase(),
		            candidate.getLastName().toUpperCase(),
		            Integer.parseInt(candidate.getYearOfbirth()) // Doğum Yılı
		            );
		
		return result;
	}

}
