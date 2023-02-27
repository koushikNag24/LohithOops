package model.sections.sectiong;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Status;
import model.sections.base.BaseHealth;
@Getter
@Entity
@Setter
@NoArgsConstructor
public class SyslogStatus extends BaseHealth {


    @OneToOne
    private SectionG sectionG;
    public SyslogStatus(String name, Status status, String issues) {
        super(name, status, issues);
    }
}
