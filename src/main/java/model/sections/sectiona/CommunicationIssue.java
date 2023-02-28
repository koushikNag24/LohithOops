package model.sections.sectiona;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.sections.base.BaseHealth;
import model.sections.sectionh.StnLookAngle;

import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class CommunicationIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comIssue")
    @SequenceGenerator(name = "comIssue",sequenceName = "comIssueSeq",allocationSize = 1)
    @Column(name = "communicationId",updatable = false, nullable = false)
    private Long id;

    @OneToMany(mappedBy = "communicationIssue", cascade = CascadeType.ALL)
    private Set<LinkStatus> baseHealths = new HashSet<>();
    @OneToOne
    private SectionA sectionA;



    public CommunicationIssue(Set<LinkStatus> baseHealths) {

        this.baseHealths = baseHealths;

    }

    public void addSectionA(SectionA sectionA){
        this.setSectionA(sectionA);
        sectionA.setCommunicationStatus(this);
    }
    public void addLinkStatus(LinkStatus linkStatus){
        this.baseHealths.add(linkStatus);
        linkStatus.setCommunicationIssue(this);
    }




}
