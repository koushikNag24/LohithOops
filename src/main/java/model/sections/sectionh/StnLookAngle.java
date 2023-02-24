package model.sections.sectionh;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tutorial.dao.utils.jpahibernate.model.Department;

import java.time.LocalDateTime;
@ToString
@Getter
@Entity
@Setter
@NoArgsConstructor
public class StnLookAngle {

    @ManyToOne
    @JoinColumn(name="base_issue_id ", nullable=false)
    private SectionH sectionH;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "stnLookAngle_seq")
    @SequenceGenerator(name = "stnLookAngle_seq",sequenceName = "StnLookAngle_learn",allocationSize = 3)
    @Column(name = "stnLookAngle_id", updatable = false, nullable = false)
    private Long id;



    private  String location;
    private LocalDateTime availableTill;

    public StnLookAngle(String location, LocalDateTime availableTill) {
        this.location = location;
        this.availableTill = availableTill;
    }

    public void addSectionH(SectionH sectionH){
        this.setSectionH(sectionH);
        sectionH.addStnLookAngle(this);
    }

}
