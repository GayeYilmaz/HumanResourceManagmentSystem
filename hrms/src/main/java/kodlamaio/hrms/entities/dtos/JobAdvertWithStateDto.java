package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertWithStateDto {
	private int id;
	private String jobPosition;
	private int numberOfStaff;
	private LocalDate deadline;
	private String companyName;
	private boolean state;
	

}
