package model.sections.sectionc;

import model.sections.base.BaseValue;

public class TwstftOffset extends BaseValue {
    private final String issues;

    public TwstftOffset(String name, Double value, String issues) {
        super(name, value);
        this.issues = issues;
    }
}
