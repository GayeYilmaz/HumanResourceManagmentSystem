package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="job_advert")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvert {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="job_position")
	private String jobPosition;
	
	@Column(name="city")
	private String city;
	
	@Column(name="description")
	private String description;
	
	@Column(name="salary_min")
	private int salaryMin;
	
	@Column(name="salary_max")
	private int salaryMax;
	
	@Column(name="number_of_staff")
	private int numberOfStaff;
	
	@Column(name="deadline")
	private LocalDate deadline;
	
	@Column(name="state")
	private boolean state;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	

}
