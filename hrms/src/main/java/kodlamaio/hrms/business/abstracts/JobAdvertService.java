package kodlamaio.hrms.business.abstracts;


import java.text.ParseException;
import java.util.Date;
import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

import kodlamaio.hrms.entities.dtos.JobAdvertWithDeadlineAndStateDto;
import kodlamaio.hrms.entities.dtos.JobAdvertWithEmployerDto;
import kodlamaio.hrms.entities.dtos.JobAdvertWithStateDto;


public interface JobAdvertService {
      Result add(JobAdvert jobAdvert);
      DataResult<List<JobAdvert>> getByState(boolean state);
      DataResult<List<JobAdvert>> getByStateAndDeadline(boolean state,Date date);
    
      DataResult<List<JobAdvertWithStateDto>> getJobAdvertWithDeatils();
      
      DataResult<List<JobAdvertWithDeadlineAndStateDto>> getJobAdvertWithDeadlineAndState(String date) throws ParseException;
      
      DataResult<List<JobAdvertWithEmployerDto>> getJobAdvertWithEmployer(int id);
      
}
