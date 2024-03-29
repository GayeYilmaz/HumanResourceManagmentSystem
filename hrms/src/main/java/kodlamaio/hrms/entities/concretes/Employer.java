package kodlamaio.hrms.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
@DiscriminatorValue("Employer")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
@Table(name="employers")
public class Employer extends User{
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_domain")
	private String webDomain;
	
	@Column(name="phone")
	private String phone;
	
	@OneToMany(mappedBy="employer")
	private List<JobAdvert> jobAdverts;

}
