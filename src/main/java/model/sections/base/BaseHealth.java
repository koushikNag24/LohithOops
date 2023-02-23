package model.sections.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Status;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class
BaseHealth {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "baseHealthSeq")
    @SequenceGenerator(name = "baseHealth",sequenceName = "baseHealthLearn",allocationSize = 2)
    @Column(name = "baseHealthId",updatable = false, nullable = false)
    private Long id;

    private  String name;
    @Enumerated(EnumType.STRING)
    private  Status status;

    public BaseHealth(String name, Status status) {
        this.name = name;
        this.status = status;
    }
}
