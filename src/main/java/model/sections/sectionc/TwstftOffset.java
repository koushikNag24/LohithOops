package model.sections.sectionc;

import lombok.Getter;
import model.sections.base.BaseValue;
@Getter
public class TwstftOffset extends BaseValue {
    private final String issues;

    public TwstftOffset(String name, Double value, String issues) {
        super(name, value);
        this.issues = issues;
    }
}
