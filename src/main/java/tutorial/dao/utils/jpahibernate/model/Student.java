package tutorial.dao.utils.jpahibernate.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@ToString
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class Student {
    @ManyToOne
    @JoinColumn(name = "fk_dept")
    private Department department;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
            joinColumns = { @JoinColumn(name = "fk_student") },
            inverseJoinColumns = { @JoinColumn(name = "fk_course")})
    private Set<Course> courses=new HashSet<>();
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq")
    @SequenceGenerator(name = "student_seq",sequenceName = "student_seq_learn",allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String city;
    private String state;
    private String email;
    private int pocketMoney;




    public Student(String name, String city, String state, String email, int pocketMoney) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.email = email;
        this.pocketMoney = pocketMoney;
    }
    public void addDepartment(Department department){
        this.setDepartment(department);
        department.addStudent(this);
    }
    public void addCourse(Course course){
        this.courses.add(course);
        course.getStudents().add(this);
    }
}
