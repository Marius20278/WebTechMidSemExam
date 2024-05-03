package model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "academic_unit")
public class AcademicUnit {

    @Id
    @Column(name = "academic_id")
    private String academicId;

    @Column(name = "academic_code")
    private String academicCode;

    @Column(name = "academic_name")
    private String academicName;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "department")
    private Set<StudentRegistration> studentRegistrations;

    public AcademicUnit() {
    }

    public AcademicUnit(String academicId, String academicCode, String academicName, String type) {
        this.academicId = academicId;
        this.academicCode = academicCode;
        this.academicName = academicName;
        this.type = type;
    }

    public String getAcademicId() {
        return academicId;
    }

    public void setAcademicId(String academicId) {
        this.academicId = academicId;
    }

    public String getAcademicCode() {
        return academicCode;
    }

    public void setAcademicCode(String academicCode) {
        this.academicCode = academicCode;
    }

    public String getAcademicName() {
        return academicName;
    }

    public void setAcademicName(String academicName) {
        this.academicName = academicName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<StudentRegistration> getStudentRegistrations() {
        return studentRegistrations;
    }

    public void setStudentRegistrations(Set<StudentRegistration> studentRegistrations) {
        this.studentRegistrations = studentRegistrations;
    }
    
    
    public void setDepartmentId(String departmentId) {
        
    }

    
    public String getDepartmentId() {
        
        return null;
    }
}
