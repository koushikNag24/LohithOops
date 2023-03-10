package tutorial.dao.utils.jpahibernate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
@Audited
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
@NamedQuery(
        name = "get_adhar_by_state",
        query = " select a from AdharCard a where state= :state",
        hints = {
                @QueryHint(
                        name = "org.hibernate.readOnly",
                        value = "true"
                )
        }
)

public class AdharCard {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "adharSeq"
    )
    @GenericGenerator(
            name = "adharSeq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequenceName",value = "productSeq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value",value = "100"),
                    @org.hibernate.annotations.Parameter(name = "increment_size",value = "3"),
                    @org.hibernate.annotations.Parameter(name = "optimizer",value = "pooled-lo"),
            }

    )
    @SequenceGenerator(name = "adharSeq",sequenceName = "adharSeqJob",allocationSize = 10)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String name;
    private String state;
    private boolean active;
   @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Student student;
}
