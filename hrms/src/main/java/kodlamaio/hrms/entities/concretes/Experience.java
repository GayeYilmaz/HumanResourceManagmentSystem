package kodlamaio.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="experiences")
public class Experience {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="entry_date")
	private String entryDate;
	
	@Column(name="finish_date")
	private String finishDate;
	
	@Column(name="position")
	private String position;
	
	@Column(name="is_continue")
	private boolean isContinue;
	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	@JsonIgnore()
    private Cv cv;
	
}
