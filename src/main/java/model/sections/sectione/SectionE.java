package model.sections.sectione;

import lombok.Getter;
import model.sections.base.BaseMaintenance;

import java.util.List;
@Getter
public class SectionE extends BaseMaintenance {
    public SectionE(String issues, List<String> stationNames) {
        super(issues, stationNames);
    }
}
