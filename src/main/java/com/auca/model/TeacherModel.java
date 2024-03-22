package com.auca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.auca.model.EAcademicUnit;


@Entity
@Table(name = "teacher")
public class TeacherModel {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;
    
    @Column(name = "tutor")
    private String tutor;
    
    @Column(name = "assistant_tutor")
    private String assistant_tutor;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "qualification")
    private EQualification qualification;

    

    public TeacherModel() {
        super();
    }



	public TeacherModel(String code, String name, String tutor, String assistant_tutor, EQualification qualification) {
		super();
		this.code = code;
		this.name = name;
		this.tutor = tutor;
		this.assistant_tutor = assistant_tutor;
		this.qualification = qualification;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTutor() {
		return tutor;
	}



	public void setTutor(String tutor) {
		this.tutor = tutor;
	}



	public String getAssistant_tutor() {
		return assistant_tutor;
	}



	public void setAssistant_tutor(String assistant_tutor) {
		this.assistant_tutor = assistant_tutor;
	}



	public EQualification getQualification() {
		return qualification;
	}



	public void setQualification(EQualification qualification) {
		this.qualification = qualification;
	}


}
