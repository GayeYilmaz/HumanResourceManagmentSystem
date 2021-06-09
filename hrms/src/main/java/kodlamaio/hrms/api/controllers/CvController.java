package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/cvs")
public class CvController {
	
	CvService cvService;

	@Autowired
	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
	}
	@PostMapping("/add")
	public Result addCv(@RequestBody  Cv cv) {
		
	    return this.cvService.addCv(cv);
	}
	@GetMapping("/getall")
	public DataResult<Cv> getAllByJobSeekerId(int userId){
		return this.cvService.getAllByJobSeekerId(userId);
		
	}
	@GetMapping("/getallByUserIdOrderSchools")
	public DataResult<List<Cv>> getAllByJobSeekerIdOrderBySchools_EntryDateDesc(int userId){
		return this.cvService. getAllByJobSeekerIdOrderBySchools_EntryDateDesc( userId);
		
	}
	@GetMapping("/getallByUserIdOrderExperience")
	public DataResult<List<Cv>> getAllByJobSeekerIdOrderByExperiences_EntryDateDesc(int userId){
		return this.cvService. getAllByJobSeekerIdOrderByExperiences_EntryDateDesc( userId);
		
	}
	

}
