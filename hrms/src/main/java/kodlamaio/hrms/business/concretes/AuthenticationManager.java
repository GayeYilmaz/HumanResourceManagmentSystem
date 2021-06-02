package kodlamaio.hrms.business.concretes;
 
import java.rmi.RemoteException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthenticationService;
import kodlamaio.hrms.entities.concretes.Employer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;



@Component
@Service
public class AuthenticationManager implements  AuthenticationService{

	@Override
	public boolean authenticationByMernis(String identityNumber,String name,String surname,int birthYear) throws RemoteException {
		
		KPSPublicSoapProxy client=new KPSPublicSoapProxy(); 
	
	    return client.TCKimlikNoDogrula(Long.parseLong(identityNumber),name.toUpperCase(),surname.toUpperCase(),birthYear);
			
		
	
	}

	@Override
	public boolean authenticationByEmail(String email) {
		UUID uuid = UUID.randomUUID();
	    String code= uuid.toString();
		System.out.println(email +"Verification code sent to address . Verification code:" + code );
		return true;
	}

	@Override
	public boolean authenticationByHRMS(Employer employer) {
		System.out.println(employer.getCompanyName()+" company information send to the HRMS to authentication."  );
		return true;
	}

	


}