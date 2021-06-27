package tr.gov.nvi.tckimlik.WS;

import java.rmi.RemoteException;

public class Main {

	public static void main(String[] args) throws RemoteException{
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		
		boolean result = true;
		
		try {
			result = kpsPublicSoapProxy.TCKimlikNoDogrula
					(Long.parseLong("15548360226"), 
					"IKRA",
					"NERGİZ", 
					2001);
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}

}
