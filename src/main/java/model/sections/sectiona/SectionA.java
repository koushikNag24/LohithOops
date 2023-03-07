package model.sections.sectiona;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.NavicPerformanceDetails;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class SectionA {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "secA")
    @SequenceGenerator(name = "secA",sequenceName = "secASeq",allocationSize = 5)
    private Long id;

    @OneToOne(mappedBy = "sectionA",cascade = CascadeType.ALL)
    private CommunicationIssue communicationStatus;

    @OneToOne(mappedBy = "sectionA",cascade = CascadeType.ALL)
    private NavicPerformanceDetails navicPerformanceDetails;

    public void addCommunicationStatus(CommunicationIssue communicationIssue){
        this.setCommunicationStatus(communicationIssue);
        communicationIssue.setSectionA(this);
    }

    public SectionA(CommunicationIssue communicationStatus) {
        this.communicationStatus = communicationStatus;
    }
}
