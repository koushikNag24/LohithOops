package model.sections.sectionc;

import model.sections.base.BaseValue;

public class GnssOffset extends BaseValue {
    private final String issues;

    public GnssOffset(String name, Double value, String issues) {
        super(name, value);
        this.issues = issues;
    }
}
