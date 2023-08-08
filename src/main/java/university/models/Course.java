package university.models;

import jakarta.persistence.*;
import university.models.interfaces.InformationPrinter;

import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.Set;

@Entity
@NamedQuery(
        name="Course.findByCoordinator",
        query="SELECT c FROM Course c WHERE c.courseCoordinator = :name"
)
@Table(name = "course")
public class Course implements InformationPrinter {
    private @Id
    @GeneratedValue Long id;
    private String courseId;
    private String courseName;
    private String courseCoordinator;
    private String description;
    private String syllabus;

    @OneToOne
    PersonFaculty faculty;
    @OneToMany
    ArrayList<PersonStudent> students;


    protected Course() {}

    public Course(String courseId, String courseName, String courseCoordinator) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCoordinator = courseCoordinator;
    }

    public Long getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCoordinator() {
        return courseCoordinator;
    }

    public String getDescription() {
        return description;
    }

    public String getSyllabus() {
        return syllabus;
    }

    @Override
    public String getInformation() {
        return "Description: " + this.description + "\nSyllabus: " + this.syllabus;
    }

    @Override
    public HTML format() {
        return null;
    }
}
