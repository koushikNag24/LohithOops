package model.sections.sectionf;

import lombok.Getter;
import model.sections.base.BaseMaintenance;

import java.util.List;
@Getter
public class SectionF extends BaseMaintenance {
    public SectionF(String issues, List<String> stationNames) {
        super(issues, stationNames);
    }
}
