package tutorial.dao.utils.jpahibernate.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.math.BigDecimal;
@Audited
@Entity
@ToString
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vehicleSeq")
    @SequenceGenerator(name = "vehicleSeq",sequenceName = "vehicleSeq",allocationSize = 20)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String color;
    private BigDecimal cost;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id",
             foreignKey = @ForeignKey(name = "Student_ID_FK")
    )
    private Student student;
}
