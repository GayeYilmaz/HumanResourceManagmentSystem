package kodlamaio.hrms.business.concretes;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthenticationService;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
    private AuthenticationService authenticationService;
	
	

    @Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,AuthenticationService authenticationService) {
	    super();
		this.jobSeekerDao = jobSeekerDao;
		this.authenticationService=authenticationService;
	
	
    }
   

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>> (this.jobSeekerDao.findAll(),"Jobseeker listed.");
	}

	@Override
	public Result add(JobSeeker jobSeeker) throws RemoteException {
		System.out.println(jobSeeker.getIdentityNo());
		if(!checkAllNull(jobSeeker)) {
			
			return new ErrorResult("All fields are obligatory.");
		}
		
		if(!checkPasswordMatch(jobSeeker)) {
			
			return new ErrorResult("Passwords are not matching.");
		}
	  
	   if(getByEmail(jobSeeker.getEmail()).isSuccess()==true) {
		   
	    	return new ErrorResult("This email is used.");
	    }
		if(getByIdentityNo(jobSeeker.getIdentityNo()).isSuccess()==true) {
			 
	    	return new ErrorResult("This identity number is used" );
	    }
	    
	    
		 if(!authenticationService.authenticationByMernis(jobSeeker.getIdentityNo(),jobSeeker.getName(), jobSeeker.getSurname(),jobSeeker.getBirthYear())) {
			 
			
			return new ErrorResult("This person is not real.");
			
		}
		
	    
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Jobseeker added");
		
		
	    }
	
	public boolean checkAllNull(JobSeeker jobSeeker) {
		
		if((jobSeeker.getName()=="")) {
			
			return false;
		}
		else if(jobSeeker.getSurname()=="") {
			
			return false;
		}
		else if(jobSeeker.getBirthYear()==0) {
			
			return false;
		}
		else if(jobSeeker.getIdentityNo()=="") {
			return false;
		}
		
		else if(jobSeeker.getEmail()=="") {
			
			return false;
		}
		else if(jobSeeker.getPassword()=="") {
			
			return false;
		}
		else if(jobSeeker.getPassword_repeat()=="") {
			
			return false;
		}
		else {
		
			return true;
		}
	}
	
	
	public boolean checkPasswordMatch(JobSeeker jobSeeker) {
		if(jobSeeker.getPassword().equals(jobSeeker.getPassword_repeat())) {
			return true;
		}
		return false;
	}


	@Override
	public DataResult<JobSeeker> getByEmail(String email) {
		
		if(this.jobSeekerDao.getByEmail(email)!=null) {
			return new SuccessDataResult<JobSeeker>();
		}
		return new ErrorDataResult<JobSeeker>();
		
		
	}


	@Override
	public DataResult<JobSeeker> getByIdentityNo(String identityNo) {
		if(this.jobSeekerDao.getByIdentityNo(identityNo)!=null) {
			return new SuccessDataResult<JobSeeker>();
		}
		return new ErrorDataResult<JobSeeker>();
	}


	

}
