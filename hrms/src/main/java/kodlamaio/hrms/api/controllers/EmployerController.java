package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvert;


@RestController
@RequestMapping("/api/employers")
public class EmployerController {
	EmployerService employerService;
	    
	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
		
	}
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
	    return this.employerService.add(employer);
	}
	
	
	
	//@PostMapping("/addJobAdvert")
	//public Result addJobAdvert(@RequestBody JobAdvert jobAdvert) {
		//return this.employerService.addJobAdvert(jobAdvert);
	//}
	


}
