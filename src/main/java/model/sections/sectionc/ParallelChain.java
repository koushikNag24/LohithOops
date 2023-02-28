package model.sections.sectionc;

import lombok.Getter;
import model.Status;
import model.sections.base.BaseHealth;
@Getter
public class ParallelChain extends BaseHealth {
    private final String issues;

    public ParallelChain(String name, Status status, String issues) {
        super(name, status);
        this.issues = issues;
    }


}
