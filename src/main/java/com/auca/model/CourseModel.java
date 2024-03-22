package com.auca.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "course")
public class CourseModel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    private String id;

	@Column(name = "student_id")
    private String student_id;

    @Column(name = "academic_unit_id")
    private String academic_unit_id;

    @Column(name = "teacherID")
    private String teacherID;

    @Column(name = "semester")
    private String semester;

    @Column(name = "coursedefinitionid")
    private String coursedefinitionid;
    
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "regNo", insertable = false, updatable = false)
    private StudentModel student;

    @ManyToOne
    @JoinColumn(name = "academic_unit_id", referencedColumnName = "code", insertable = false, updatable = false) // Establish a foreign key relationship
    private AcademicModel academicUnit;
    
    @ManyToOne
    @JoinColumn(name = "teacherID", referencedColumnName = "code", insertable = false, updatable = false)
    private TeacherModel teacher;

    @ManyToOne
    @JoinColumn(name = "semester", referencedColumnName = "id", insertable = false, updatable = false)
    private SemesterModel semesterInfo;

    @ManyToOne
    @JoinColumn(name = "coursedefinitionid", referencedColumnName = "id", insertable = false, updatable = false)
    private CDefinitionModel courseDefinition;

	public CourseModel() {
		super();
	}

	public CourseModel(String id, String student_id, String academic_unit_id, String teacherID, String semester,
			String coursedefinitionid, StudentModel student, AcademicModel academicUnit, TeacherModel teacher,
			SemesterModel semesterInfo, CDefinitionModel courseDefinition) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.academic_unit_id = academic_unit_id;
		this.teacherID = teacherID;
		this.semester = semester;
		this.coursedefinitionid = coursedefinitionid;
		this.student = student;
		this.academicUnit = academicUnit;
		this.teacher = teacher;
		this.semesterInfo = semesterInfo;
		this.courseDefinition = courseDefinition;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getAcademic_unit_id() {
		return academic_unit_id;
	}

	public void setAcademic_unit_id(String academic_unit_id) {
		this.academic_unit_id = academic_unit_id;
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getCoursedefinitionid() {
		return coursedefinitionid;
	}

	public void setCoursedefinitionid(String coursedefinitionid) {
		this.coursedefinitionid = coursedefinitionid;
	}

	public StudentModel getStudent() {
		return student;
	}

	public void setStudent(StudentModel student) {
		this.student = student;
	}

	public AcademicModel getAcademicUnit() {
		return academicUnit;
	}

	public void setAcademicUnit(AcademicModel academicUnit) {
		this.academicUnit = academicUnit;
	}

	public TeacherModel getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherModel teacher) {
		this.teacher = teacher;
	}

	public SemesterModel getSemesterInfo() {
		return semesterInfo;
	}

	public void setSemesterInfo(SemesterModel semesterInfo) {
		this.semesterInfo = semesterInfo;
	}

	public CDefinitionModel getCourseDefinition() {
		return courseDefinition;
	}

	public void setCourseDefinition(CDefinitionModel courseDefinition) {
		this.courseDefinition = courseDefinition;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

  

	
}
