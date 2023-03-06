package model.sections.sectionh;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.NavicPerformanceDetails;
import model.sections.base.BaseIssues;

import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class SectionH extends BaseIssues {
    @OneToMany(mappedBy="sectionH", cascade = CascadeType.ALL)
    private Set<StnLookAngle> stnLookAngles=new HashSet<>();

    @OneToOne(mappedBy = "sectionH",cascade = CascadeType.ALL)
    private NavicPerformanceDetails navicPerformanceDetails;


    public SectionH(String issuesFromSectionH, Set<StnLookAngle> stnLookAngles) {
        super(issuesFromSectionH);
        this.stnLookAngles = stnLookAngles;
    }

    public void addStnLookAngle(StnLookAngle stnLookAngle){
        this.stnLookAngles.add(stnLookAngle);
        stnLookAngle.setSectionH(this);
    }
}
