package tutorial.dao;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@Setter
@Getter

@NoArgsConstructor
@Table(name = "Department_Table")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "dept_seq")
    @SequenceGenerator(name = "dept_seq",sequenceName = "depart_seq_learn",allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long deptId;

    @Check(constraints = "CASE WHEN firstName IS NOT NULL THEN LENGTH(firstName) >= 5 ELSE true END")
    @Column(length = 233)
    private String firstName;

    private String nextName;

    @ColumnDefault("'Bengalore University'")
    private String college;

    @Column(name = "start_date")
    private LocalDate startDate;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime insertedAt;

    @UpdateTimestamp
    private LocalDateTime modifiedAt;
}
