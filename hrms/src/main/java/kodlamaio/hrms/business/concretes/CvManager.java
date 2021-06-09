package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.School;


@Service
public class CvManager implements CvService{
	CvDao cvDao;
	

	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}


	@Override
	public DataResult<Cv> getAllByJobSeekerId(int UserId) {
		
		return new SuccessDataResult<Cv>(this.cvDao.getAllByJobSeekerId(UserId),"All cv are listed");
	}


	@Override
	public Result addCv(Cv cv) {
	     
		this.cvDao.save(cv);
		return new SuccessResult("Cv added");
	}


	@Override
	public DataResult<List<Cv>> getAllByJobSeekerIdOrderBySchools_EntryDateDesc(int userId) {
		
		return new SuccessDataResult<List<Cv>>(this.cvDao.getAllByJobSeekerIdOrderBySchools_EntryDateDesc(userId),"Ordered by entry date");
	}


	@Override
	public DataResult<List<Cv>> getAllByJobSeekerIdOrderByExperiences_EntryDateDesc(int userId) {
		return new SuccessDataResult<List<Cv>>(this.cvDao.getAllByJobSeekerIdOrderByExperiences_EntryDateDesc(userId),"Ordered by entry date");
		
	}


	
	

}
