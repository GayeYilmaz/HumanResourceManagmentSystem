package kodlamaio.hrms.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();
	Result add(JobSeeker jobSeeker) throws RemoteException;
	DataResult<JobSeeker> getByEmail(String email);
	DataResult<JobSeeker> getByIdentityNo(String identityNo);



}
 