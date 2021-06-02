package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	private JobPositionDao jobPositionDao;
	
    
    @Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Job positions listed.");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		System.out.println(getByPosition(jobPosition.getPosition()).isSuccess());
		if(getByPosition(jobPosition.getPosition()).isSuccess()==true) {
			return new ErrorResult("This position added already.");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Job position added.");
		
	}

	@Override
	public DataResult<JobPosition> getByPosition(String position) {
         System.out.println(this.jobPositionDao.getByPosition(position));
		if(this.jobPositionDao.getByPosition(position)!=null) {
			return new SuccessDataResult<JobPosition>();
		}
		return new ErrorDataResult<JobPosition>();
	}

}
