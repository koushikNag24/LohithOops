package tutorial.dao.utils.jpahibernate.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.Audited;

@Audited
@Entity
@ToString
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Table(name = "emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "empSeq")
    @SequenceGenerator(name = "empSeq",sequenceName = "empSeq",allocationSize = 2)
    @Column(updatable = false, nullable = false)
    private Long id;

    @NaturalId(mutable = true)
    @Audited(withModifiedFlag = true)
    private String istracEmployeeID;

    @Audited(withModifiedFlag = true)
    private String name;


}
