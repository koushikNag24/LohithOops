package tutorial.dao.utils.jpahibernate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
//@Table(
//        uniqueConstraints = @UniqueConstraint(
//                name="uk_adhar_name_state",
//                columnNames = {
//                        "name",
//                        "state"
//                }
//        )
//)
//@Where(clause = "state='china'")
public class AdharCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "adharSeq")
    @SequenceGenerator(name = "adharSeq",sequenceName = "adharSeqJob",allocationSize = 10)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String name;
    private String state;
    private boolean active;
   @ManyToOne
    @ToString.Exclude
    private Student student;
}
