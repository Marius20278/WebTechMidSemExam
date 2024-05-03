package model;

import javax.persistence.*;

@Entity
@Table(name = "course_definition")
public class CourseDefinition {

    @Id
    @Column(name = "course_definition_id")
    private String courseDefinitionId;

    @Column(name = "course_definition_code")
    private String courseDefinitionCode;

    @Column(name = "course_definition_description")
    private String courseDefinitionDescription;

//    @OneToOne(mappedBy = "courseDefinition")
//    private Course course;

    public CourseDefinition() {
    }

    public CourseDefinition(String courseDefinitionId, String courseDefinitionCode, String courseDefinitionDescription) {
        this.courseDefinitionId = courseDefinitionId;
        this.courseDefinitionCode = courseDefinitionCode;
        this.courseDefinitionDescription = courseDefinitionDescription;
    }

    public String getCourseDefinitionId() {
        return courseDefinitionId;
    }

    public void setCourseDefinitionId(String courseDefinitionId) {
        this.courseDefinitionId = courseDefinitionId;
    }

    public String getCourseDefinitionCode() {
        return courseDefinitionCode;
    }

    public void setCourseDefinitionCode(String courseDefinitionCode) {
        this.courseDefinitionCode = courseDefinitionCode;
    }

    public String getCourseDefinitionDescription() {
        return courseDefinitionDescription;
    }

    public void setCourseDefinitionDescription(String courseDefinitionDescription) {
        this.courseDefinitionDescription = courseDefinitionDescription;
    }
    }

//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }
//}
