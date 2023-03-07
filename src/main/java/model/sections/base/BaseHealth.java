package model.sections.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Status;
import model.enumer.Names;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseHealth {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "baseHealthSeq")
    @SequenceGenerator(name = "baseHealth",sequenceName = "baseHealthLearn",allocationSize = 2)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String issue;
    @Enumerated(EnumType.STRING)
    private Names name;
    @Enumerated(EnumType.STRING)
    private  Status status;



    public BaseHealth(Names name, Status status, String issue) {
        this.name = name;
        this.status = status;
        this.issue=issue;
    }

}
