package tutorial.dao.utils.jpahibernate.model;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@AllArgsConstructor
@Setter
@Getter

@NoArgsConstructor

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
    @Convert(converter = AddressConverter.class)
    private String state;

    @Formula(("concat(city,'-',state    )"))
    private String fullAddress;

    @Column
    @ColumnTransformer(read = "pgp_sym_decrypt(department_password::byte, 'mySecretKey')",
            write = "pgp_sym_encrypt(?, 'mySecretKey')")
    private String departmentPassword;

    @JdbcTypeCode( SqlTypes.JSON )
    private Map<String, Boolean> payload;

    private  BigDecimal fund;

    @Formula(value = "12 * fund")
    private BigDecimal yearlyFund;


    @ColumnDefault("'Bengalore University'")
    private String college;

    @Column(name = "start_date")
    private LocalDate startDate;

    private InetAddress address;



    @Lob

    String country;

    @Convert(converter = org.hibernate.type.TrueFalseConverter.class)
    boolean isClosed;

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
