package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthenticationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class EmployerManager implements EmployerService {
	EmployerDao employerDao;
    AuthenticationService authenticationService;
	public EmployerManager(EmployerDao employerDao,AuthenticationService authenticationService ) {
		super();
		this.employerDao = employerDao;
		this.authenticationService=authenticationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Data listed");
				
	}

	@Override
	public Result add(Employer employer) {
		
        if(!checkAllNull(employer)) {
			
			return new ErrorResult("All fields are obligatory.");
		}
		
		if(!checkPasswordMatch(employer)) {
			
			return new ErrorResult("Passwords are not matching.");
		}
	  
	   if(getByEmail(employer.getEmail()).isSuccess()==true) {
		   
	    	return new ErrorResult("This email is used.");
	    }
	   if(!authenticationService.authenticationByEmail(employer.getEmail())){
			 
			
			return new ErrorResult("This person is not real.");
			
		}
	    this.employerDao.save(employer);
	    return new SuccessResult("Employer added.");
		
	}

	
   public boolean checkAllNull(Employer employer) {
		
		if((employer.getCompanyName()=="")) {
			
			return false;
		}
		else if(employer.getPhone()=="") {
			
			return false;
		}
		else if(employer.getWebDomain()=="") {
			
			return false;
		}
		
		else if(employer.getEmail()=="") {
			
			return false;
		}
		else if(employer.getPassword()=="") {
			
			return false;
		}
		else if(employer.getPassword_repeat()=="") {
			
			return false;
		}
		else {
		
			return true;
		}
	}
    
    public boolean checkPasswordMatch(Employer employer) {
		if(employer.getPassword().equals(employer.getPassword_repeat())) {
			return true;
		}
		return false;
	}
	@Override
	public DataResult<Employer> getByEmail(String email) {
		
		if(this.employerDao.getByEmail(email)!=null) {
			return new SuccessDataResult<Employer>();
		}
		return new ErrorDataResult<Employer>();
		
		
	}

	

}
