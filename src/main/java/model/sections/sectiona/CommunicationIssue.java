package model.sections.sectiona;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.sections.base.BaseHealth;

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
    @Column(name = "LinkId",updatable = false, nullable = false)
    private Long id;

    @OneToMany(mappedBy = "communicationIssue", cascade = CascadeType.ALL)
    private Set<BaseHealth> baseHealths = new HashSet<>();
    @OneToOne
    private SectionA sectionA;



    public CommunicationIssue(Set<BaseHealth> baseHealths) {

        this.baseHealths = baseHealths;

    }
    public void addBaseHealth(BaseHealth baseHealth){
        this.baseHealths.add(baseHealth);
        baseHealth.setCommunicationIssue(this);
    }
    public void addSectionA(SectionA sectionA){
        this.setSectionA(sectionA);
        sectionA.setCommunicationStatus(this);
    }
}
