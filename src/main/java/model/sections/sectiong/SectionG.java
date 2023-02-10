package model.sections.sectiong;

import model.sections.base.BaseIssues;

public class SectionG extends BaseIssues {
    private final SyslogStatus syslogStatus;



    public SectionG(SyslogStatus syslogStatus, String issues) {
        super(issues);
        this.syslogStatus = syslogStatus;
    }
}
