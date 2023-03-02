package tutorial.dao.utils.jpahibernate.model;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ForeignKey;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@FilterDef(
        name = "indianStudent",
        parameters = @ParamDef(
                name = "state",
                type = String.class
        )
)
@Filter(
        name = "indianStudent",
        condition = "state= :state"
)
public class Student {

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkDept")
    private Department department;

    @ToString.Exclude

    @Where(clause = "active= 'true'")
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private  Set<AdharCard> activeAdharCards=new HashSet<>();

    @ToString.Exclude
    @Where(clause = "active= 'false'")
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private  Set<AdharCard> inActiveAdharCards=new HashSet<>();
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "studentCourse",
            joinColumns = { @JoinColumn(name = "fkStudent",foreignKey = @ForeignKey(name = "Student_ID_FK")) },
            inverseJoinColumns = { @JoinColumn(name = "fkCourse",foreignKey = @ForeignKey(name = "Course_ID_FK"))})
//    @WhereJoinTable(clause = "inserted_at>  DATE(NOW()) + interval '- 7 days'")
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

    @Formula(value = "30*pocket_money")
    private Double monthlyPocketMoney;


    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime insertedAt;

    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
    private Set<Vehicle> vehicles=new HashSet<>();


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
    public void addActiveAdharCard(AdharCard adharCard){
        this.activeAdharCards.add(adharCard);
        adharCard.setStudent(this);
    }
    public void addInActiveAdharCard(AdharCard adharCard){
        this.inActiveAdharCards.add(adharCard);
        adharCard.setStudent(this);
    }
    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
        vehicle.setStudent(this);
    }
}
