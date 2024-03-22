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
@Table(name = "Department") // Change the table name to "Department"
public class DepartmentModel {
    @Id
    @Column(name = "ID") // Change the column name to "ID"
    private String ID;

    @Column(name = "AcademicUnitID") // Change the column name to "AcademicUnitID"
    private String AcademicUnitID;

    @ManyToOne
    @JoinColumn(name = "AcademicUnitID", referencedColumnName = "code", insertable = false, updatable = false) // Establish a foreign key relationship
    private AcademicModel academicUnit;
    
    @Column(name = "DepartmentName") // Change the column name to "DepartmentName"
    private String DepartmentName;

  

	public DepartmentModel() {
		super();
	}



	public DepartmentModel(String iD, String academicUnitID, AcademicModel academicUnit, String departmentName) {
		super();
		ID = iD;
		AcademicUnitID = academicUnitID;
		this.academicUnit = academicUnit;
		DepartmentName = departmentName;
	}



	public String getID() {
		return ID;
	}



	public void setID(String iD) {
		ID = iD;
	}



	public String getAcademicUnitID() {
		return AcademicUnitID;
	}



	public void setAcademicUnitID(String academicUnitID) {
		AcademicUnitID = academicUnitID;
	}



	public AcademicModel getAcademicUnit() {
		return academicUnit;
	}



	public void setAcademicUnit(AcademicModel academicUnit) {
		this.academicUnit = academicUnit;
	}



	public String getDepartmentName() {
		return DepartmentName;
	}



	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}



	
}
