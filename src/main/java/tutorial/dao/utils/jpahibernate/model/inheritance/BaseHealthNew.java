package tutorial.dao.utils.jpahibernate.model.inheritance;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

@Setter
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="base_health_type",
//        discriminatorType = DiscriminatorType.STRING)
public class BaseHealthNew {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "baseHealth_seq")
    @SequenceGenerator(name = "baseHealth_seq",sequenceName = "baseHealth_seq_learn",allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private  Long id;
    private  String name;
    private  String status;

    public BaseHealthNew(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
}
