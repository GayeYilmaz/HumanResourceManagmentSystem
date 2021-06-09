package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.JobAdvert;


public interface CvService {
	Result addCv(Cv cv);
	DataResult<Cv> getAllByJobSeekerId(int id);
	DataResult<List<Cv>> getAllByJobSeekerIdOrderBySchools_EntryDateDesc(int userId);
	DataResult<List<Cv>> getAllByJobSeekerIdOrderByExperiences_EntryDateDesc(int userId);

}
