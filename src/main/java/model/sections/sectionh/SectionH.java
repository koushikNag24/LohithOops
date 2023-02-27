package model.sections.sectionh;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.sections.base.BaseIssues;
import model.sections.sectiond.SchemacsHealth;
import model.sections.sectiong.SyslogStatus;
import tutorial.dao.utils.jpahibernate.model.Student;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class SectionH extends BaseIssues {
    @OneToMany(mappedBy="sectionH", cascade = CascadeType.ALL)
    private Set<StnLookAngle> stnLookAngles=new HashSet<>();


    public SectionH(String issuesFromSectionH, Set<StnLookAngle> stnLookAngles) {
        super(issuesFromSectionH);
        this.stnLookAngles = stnLookAngles;
    }

    public void addStnLookAngle(StnLookAngle stnLookAngle){
        this.stnLookAngles.add(stnLookAngle);
        stnLookAngle.setSectionH(this);
    }
}
