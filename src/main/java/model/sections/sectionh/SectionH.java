package model.sections.sectionh;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.sections.base.BaseIssues;
import model.sections.sectiong.SyslogStatus;
import tutorial.dao.utils.jpahibernate.model.Student;

import java.util.List;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class SectionH extends BaseIssues {
    @OneToMany(mappedBy="sectionH")
    private List<StnLookAngle> stnLookAngles;
    public SectionH(String issues, List<StnLookAngle> stnLookAngles) {
        super(issues);
        this.stnLookAngles = stnLookAngles;
    }

    public void addStnLookAnlge(StnLookAngle stnLookAngle){
        this.stnLookAngles.add(stnLookAngle);
        stnLookAngle.setSectionH(this);
    }
}
