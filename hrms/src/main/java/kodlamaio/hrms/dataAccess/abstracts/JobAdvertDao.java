package kodlamaio.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

import kodlamaio.hrms.entities.dtos.JobAdvertWithDeadlineAndStateDto;
import kodlamaio.hrms.entities.dtos.JobAdvertWithEmployerDto;
import kodlamaio.hrms.entities.dtos.JobAdvertWithStateDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer>{
     List<JobAdvert> getByState(boolean state);
     List<JobAdvert> getByStateAndDeadline(boolean state,Date date);
     
     @Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertWithStateDto(j.id,j.jobPosition,j.numberOfStaff,j.deadline,e.companyName ,j.state) From JobAdvert j   Inner Join j.employer e where j.state=true  ")
	 List<JobAdvertWithStateDto> getJobAdvertWithDeatils();
     
     @Query("Select  new kodlamaio.hrms.entities.dtos.JobAdvertWithDeadlineAndStateDto(j.id,j.jobPosition,j.numberOfStaff,j.deadline,e.companyName,j.state) From JobAdvert j Inner Join j.employer e where j.state=true and j.deadline=:date ")
     List<JobAdvertWithDeadlineAndStateDto> getJobAdvertWithDeadlineAndState(LocalDate date);
     
     @Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertWithEmployerDto(e.id,j.jobPosition,j.numberOfStaff,j.deadline,e.companyName,j.state) From JobAdvert j Inner Join j.employer e where j.state=true and e.id=:id ")
     List<JobAdvertWithEmployerDto> getJobAdvertWithEmployer(int id);
     
   
     
}
