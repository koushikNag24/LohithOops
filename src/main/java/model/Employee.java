package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Audited
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "emp_seq")
    @SequenceGenerator(name = "emp_seq",sequenceName = "emp_seq_learn",allocationSize = 2)
    @Column(name = "emp_id",updatable = false, nullable = false)
    private Long id;

    private String state;

    private String city;
    private BigDecimal salary;

    private Long year;

}
