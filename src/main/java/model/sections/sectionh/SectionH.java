package model.sections.sectionh;

import lombok.Getter;
import model.sections.base.BaseIssues;

import java.util.List;
@Getter
public class SectionH extends BaseIssues {
    private final List<StnLookAngle> stnLookAngles;
    public SectionH(String issues, List<StnLookAngle> stnLookAngles) {
        super(issues);
        this.stnLookAngles = stnLookAngles;
    }
}
