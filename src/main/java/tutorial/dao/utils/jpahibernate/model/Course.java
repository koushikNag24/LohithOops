package tutorial.dao.utils.jpahibernate.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
//@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_seq")
    @SequenceGenerator(name = "course_seq",sequenceName = "course_seq_learn",allocationSize = 2)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students=new HashSet<>();

    public void addStudent(Student student){
        this.students.add(student);
        student.getCourses().add(this);
    }
}
