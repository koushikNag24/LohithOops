package model.sections.base;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public abstract class BaseIssues {
    private final String issues;

    public BaseIssues(String issues) {
        this.issues=issues;
    }
}
