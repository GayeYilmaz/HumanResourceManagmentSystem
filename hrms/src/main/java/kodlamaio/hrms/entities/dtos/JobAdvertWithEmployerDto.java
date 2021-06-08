package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertWithEmployerDto {
	private int id;
	private String jobPosition;
	private int numberOfStaff;
	private LocalDate deadline;
	private String companyName;
	private boolean state;

}
