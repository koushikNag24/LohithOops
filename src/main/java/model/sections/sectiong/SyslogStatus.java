package model.sections.sectiong;

import lombok.Getter;
import model.sections.base.BaseHealth;
@Getter
public class SyslogStatus extends BaseHealth {
    public SyslogStatus(String name, String status) {
        super(name, status);
    }
}
