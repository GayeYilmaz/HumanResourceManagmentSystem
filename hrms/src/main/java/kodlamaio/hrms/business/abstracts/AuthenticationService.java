package kodlamaio.hrms.business.abstracts;

import java.rmi.RemoteException;

import kodlamaio.hrms.entities.concretes.Employer;

public interface AuthenticationService {
	boolean authenticationByMernis(String idedtityNumber,String name,String surname,int birthYear) throws RemoteException;
	boolean authenticationByEmail(String email);
	boolean authenticationByHRMS(Employer employer);

}
