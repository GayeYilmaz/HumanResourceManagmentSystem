package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.StaffService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.StaffDao;
import kodlamaio.hrms.entities.concretes.Staff;

@Service
public class StaffManager implements StaffService {
    
	StaffDao staffDao;
	
	public StaffManager(StaffDao staffDao) {
		super();
		this.staffDao = staffDao;
	}

	@Override
	public DataResult<List<Staff>> getAll() {
	
		return new SuccessDataResult<List<Staff>>(this.staffDao.findAll(),"Çalışanlar listelendi");
	}

	@Override
	public Result add(Staff staff) {
		this.staffDao.save(staff);
		return new SuccessResult("Çalışsan eklendi");
	}

}
