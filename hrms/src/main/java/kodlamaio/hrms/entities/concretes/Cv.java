package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","skills","schools","languagaeSkills","experiences"})
@Table(name="cvs")
public class Cv {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int jobSeekerId;
	
	@Column(name="linkedIn_address")
	private String linkedInAddress;
	
	@Column(name="github_address")
	private String githubAddress;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@Column(name="avatar_url")
	private String avatarUrl;

	
	
	//skill_id
	@OneToMany( mappedBy="cv")
	private List<Skill> skills;
	
	//school_id
	@OneToMany( mappedBy="cv")
	private List<School> schools;
	
	//language_skill_id
	@OneToMany( mappedBy="cv")
    private List<LanguageSkill> languageSkills;
	
	
	//experince_id
	@OneToMany( mappedBy="cv")
	private List<Experience> experiences;
}
