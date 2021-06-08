package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
	DataResult<Employer> getByEmail(String email);
	//Result addJobAdvert(JobAdvert jobAdvert);
	
	

}
