package kodlamaio.hrms.business.concretes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;

import kodlamaio.hrms.entities.dtos.JobAdvertWithDeadlineAndStateDto;
import kodlamaio.hrms.entities.dtos.JobAdvertWithEmployerDto;
import kodlamaio.hrms.entities.dtos.JobAdvertWithStateDto;

@Service
public class JobAdvertManager implements JobAdvertService{
	JobAdvertDao jobAdvertDao;
	

	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}
	@Override
	public Result  add(JobAdvert jobAdvert) {
        if(!checkAllNull(jobAdvert)) {
			
			return new ErrorResult("All fields are obligatory.");
		}
        this.jobAdvertDao.save(jobAdvert);
	    return new SuccessResult("Job advert added.");
		
	}
public boolean checkAllNull(JobAdvert jobAdvert) {
		
		if((jobAdvert.getCity()==null)) {
			
			return false;
		}
		else if(jobAdvert.getJobPosition()==null) {
			
			return false;
		}
		else if(jobAdvert.getEmployer()==null) {
			
			return false;
		}
		
		else if(jobAdvert.getDeadline()==null) {
			
			return false;
		}
		else if(jobAdvert.getDescription()=="") {
			
			return false;
		}
		else if(jobAdvert.getNumberOfStaff()==0) {
			
			return false;
		}
		else {
		
			return true;
		}
	}
@Override
public DataResult<List<JobAdvert>> getByState(boolean state) {
	return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByState(state),"Active job positions listed.");

}
@Override
public DataResult<List<JobAdvert>> getByStateAndDeadline(boolean state, Date date) {
	
	return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByStateAndDeadline(state,date),"Active job positions listed.");



}
@Override
public DataResult<List<JobAdvertWithStateDto>> getJobAdvertWithDeatils() {
	
	return new SuccessDataResult<List<JobAdvertWithStateDto>>(this.jobAdvertDao.getJobAdvertWithDeatils(),"Data listed");
}
@Override
public DataResult<List<JobAdvertWithDeadlineAndStateDto>> getJobAdvertWithDeadlineAndState(String date) throws ParseException {
	
	
	LocalDate date1 = LocalDate.parse(date);
	
	return new SuccessDataResult<List<JobAdvertWithDeadlineAndStateDto>>(this.jobAdvertDao.getJobAdvertWithDeadlineAndState(date1 ),"Data listed.");
}
@Override
public DataResult<List<JobAdvertWithEmployerDto>> getJobAdvertWithEmployer(int id) {
	
	return new SuccessDataResult<List<JobAdvertWithEmployerDto>>(this.jobAdvertDao.getJobAdvertWithEmployer(id ),"Data listed.");
}


}