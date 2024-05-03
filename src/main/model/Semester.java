package model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "semester")
public class Semester {

    @Id
    @Column(name = "semester_id")
    private String semesterId;

    @Column(name = "semester_name")
    private String semesterName;

    @Column(name = "starting_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startingDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @OneToMany(mappedBy = "semester")
    private Set<StudentRegistration> studentRegistrations;

    @OneToMany(mappedBy = "semester")
    private Set<Course> courses;

    public Semester() {
    }

    public Semester(String semesterId, String semesterName, Date startingDate, Date endDate) {
        this.semesterId = semesterId;
        this.semesterName = semesterName;
        this.startingDate = startingDate;
        this.endDate = endDate;
    }
    public String getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(String semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<StudentRegistration> getStudentRegistrations() {
        return studentRegistrations;
    }

    public void setStudentRegistrations(Set<StudentRegistration> studentRegistrations) {
        this.studentRegistrations = studentRegistrations;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
