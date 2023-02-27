package tutorial.dao.utils.jpahibernate.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class Student {

    @ManyToOne
    @JoinColumn(name = "fkDept")
    private Department department;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "studentCourse",
            joinColumns = { @JoinColumn(name = "fkStudent") },
            inverseJoinColumns = { @JoinColumn(name = "fkCourse")})
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

    @Formula(value = "30*pocketMoney")
    private Double monthlyPocketMoney;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime insertedAt;

    @UpdateTimestamp
    private LocalDateTime modifiedAt;


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
