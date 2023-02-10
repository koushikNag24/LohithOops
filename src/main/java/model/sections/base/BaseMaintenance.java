package model.sections.base;

import lombok.Getter;

import java.util.List;
@Getter
public class BaseMaintenance extends BaseIssues {
    private final List<String> stationNames;

    public BaseMaintenance(String issues, List<String> stationNames) {
        super(issues);
        this.stationNames = stationNames;
    }
}
