package model.sections.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Status;
import model.sections.sectiona.CommunicationIssue;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseHealth {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "baseHealthSeq")
    @SequenceGenerator(name = "baseHealth",sequenceName = "baseHealthLearn",allocationSize = 2)
    @Column(name = "baseHealthId",updatable = false, nullable = false)
    private Long id;

    private String issue;
    private  String name;
    @Enumerated(EnumType.STRING)
    private  Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wrong_name")
    private CommunicationIssue communicationIssue;

    public BaseHealth(String name, Status status, String issue) {
        this.name = name;
        this.status = status;
        this.issue=issue;
    }
    public void addCommunicationIssues(CommunicationIssue communicationIssue){
        this.setCommunicationIssue(communicationIssue);
        communicationIssue.addBaseHealth(this);
    }
}
