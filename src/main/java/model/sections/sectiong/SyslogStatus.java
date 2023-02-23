package model.sections.sectiong;

import lombok.Getter;
import model.Status;
import model.sections.base.BaseHealth;
@Getter
public class SyslogStatus extends BaseHealth {
    public SyslogStatus(String name, Status status) {
        super(name, status);
    }
}
