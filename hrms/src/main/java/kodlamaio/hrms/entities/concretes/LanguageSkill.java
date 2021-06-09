package kodlamaio.hrms.entities.concretes;





import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="language_skills")

public class LanguageSkill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="skill_level")
    private int skillLevel;
	
	@Column(name="languages_id")
    private int languagesId;
	

	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	@JsonIgnore()
    private Cv cv;

	
	
}
