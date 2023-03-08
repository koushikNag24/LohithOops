package model.sections.sectiong;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Status;
import model.sections.base.BaseHealth;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Getter
@Entity
@Setter
@NoArgsConstructor
@Audited
public class SyslogStatus extends BaseHealth {


    @OneToOne
    @Audited(targetAuditMode =  RelationTargetAuditMode.NOT_AUDITED)
    private SectionG sectionG;
    public SyslogStatus(String name, Status status) {
        super(name, status);
    }
}
