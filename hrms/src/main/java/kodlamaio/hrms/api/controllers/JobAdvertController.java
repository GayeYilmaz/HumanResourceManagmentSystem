package kodlamaio.hrms.api.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.concretes.JobPosition;

import kodlamaio.hrms.entities.dtos.JobAdvertWithDeadlineAndStateDto;
import kodlamaio.hrms.entities.dtos.JobAdvertWithEmployerDto;
import kodlamaio.hrms.entities.dtos.JobAdvertWithStateDto;

@RestController
@RequestMapping("/api/jobAdverts")
@CrossOrigin
public class JobAdvertController {
	JobAdvertService jobAdvertService;
    
	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService =jobAdvertService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
	    return this.jobAdvertService.add(jobAdvert);
	}
	@GetMapping("/getByState")
	public DataResult<List<JobAdvert>> getByState(boolean state){
		return this.jobAdvertService.getByState(state);
		
	}
	
	@GetMapping("/getJobAdvertWithDeatils")
	public DataResult<List<JobAdvertWithStateDto>> getJobAdvertWithDeatils() {
		
		return this.jobAdvertService.getJobAdvertWithDeatils();
	}
	
	@GetMapping("/getJobAdvertWithDeadlineAndState")
	public DataResult<List<JobAdvertWithDeadlineAndStateDto>> getJobAdvertWithDeadlineAndState( @RequestParam("deadline") String date) throws ParseException {
		
		return this.jobAdvertService.getJobAdvertWithDeadlineAndState(date);
	}
	
	@GetMapping("/getJobAdvertWithEmployer")
   public DataResult<List<JobAdvertWithEmployerDto>> getJobAdvertWithEmployer( int id)  {
		
		return this.jobAdvertService.getJobAdvertWithEmployer(id);
	}
	
	

}
