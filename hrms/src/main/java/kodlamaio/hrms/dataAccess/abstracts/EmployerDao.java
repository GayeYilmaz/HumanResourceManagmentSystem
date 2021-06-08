package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvert;




public interface EmployerDao extends JpaRepository<Employer,Integer> {
	Employer getByEmail(String email);
    //JobAdvert addJobAdvert(JobAdvert jobAdvert);
	
	

}
