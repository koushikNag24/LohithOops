package model.sections.sectionc;

import model.sections.base.BaseHealth;

public class ParallelChain extends BaseHealth {
    private final String issues;

    public ParallelChain(String name, String status, String issues) {
        super(name, status);
        this.issues = issues;
    }


}
