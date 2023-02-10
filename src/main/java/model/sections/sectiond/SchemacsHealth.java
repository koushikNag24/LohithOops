package model.sections.sectiond;

import lombok.Getter;
import lombok.ToString;
import model.sections.base.BaseHealth;
@ToString
@Getter
public class SchemacsHealth extends BaseHealth {
    private final String issues;

    public SchemacsHealth(String name, String status, String issues) {
        super(name, status);
        this.issues = issues;
    }
}
