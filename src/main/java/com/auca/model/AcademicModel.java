package com.auca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "academicunit")
public class AcademicModel {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;
    
    @Column(name = "parentId")
    private String parentId;
    // Add a field to represent the academic unit type
    
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "academicUnitType")
    private EAcademicUnit academicUnitType;

    // Add a field for self-referencing parent academic unit
    @ManyToOne
    @JoinColumn(name = "parentId", referencedColumnName = "code", insertable = false, updatable = false)
    private AcademicModel parentAcademicUnit;

    public AcademicModel() {
        super();
    }

	public AcademicModel(String code, String name, String parentId, EAcademicUnit academicUnitType,
			AcademicModel parentAcademicUnit) {
		super();
		this.code = code;
		this.name = name;
		this.parentId = parentId;
		this.academicUnitType = academicUnitType;
		this.parentAcademicUnit = parentAcademicUnit;
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public EAcademicUnit getAcademicUnitType() {
		return academicUnitType;
	}

	public void setAcademicUnitType(EAcademicUnit academicUnitType) {
		this.academicUnitType = academicUnitType;
	}

	public AcademicModel getParentAcademicUnit() {
		return parentAcademicUnit;
	}

	public void setParentAcademicUnit(AcademicModel parentAcademicUnit) {
		this.parentAcademicUnit = parentAcademicUnit;
	}

}
