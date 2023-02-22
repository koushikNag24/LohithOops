package tutorial.dao.utils.jpahibernate.model;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@Setter
@Getter

@NoArgsConstructor
@Table(name = "Department_Table")
public class Department {
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "dept_seq")
    @SequenceGenerator(name = "dept_seq",sequenceName = "depart_seq_learn",allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long deptId;

    @Check(constraints = "CASE WHEN name IS NOT NULL THEN LENGTH(name) >= 2 ELSE true END")
    @Column(length = 233)
    private String name;

    private String city;
    private String state;

    @ColumnDefault("'Bengalore University'")
    private String college;

    @Column(name = "start_date")
    private LocalDate startDate;



    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime insertedAt;

    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    public void addStudent(Student student){
        this.students.add(student);
        student.setDepartment(this);
    }
}
