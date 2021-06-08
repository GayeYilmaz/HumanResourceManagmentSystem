package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="job_seekers")
@PrimaryKeyJoinColumn(name="id")
@DiscriminatorValue("JobSeeker")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User {
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="identity_no")
	private String identityNo;
	
	@Column(name="birth_year")
	private int birthYear;
	
	
    
	
    
	
}
