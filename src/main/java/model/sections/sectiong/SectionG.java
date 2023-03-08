package model.sections.sectiong;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.sections.base.BaseIssues;
import org.hibernate.envers.Audited;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class SectionG extends BaseIssues {

    @OneToOne(mappedBy = "sectionG",cascade = CascadeType.ALL)
    private  SyslogStatus syslogStatus;



    public SectionG(SyslogStatus syslogStatus, String issues) {
        super(issues);
        this.syslogStatus = syslogStatus;
    }
    public void addSysLog(SyslogStatus syslogStatus){
        this.setSyslogStatus(syslogStatus);
        syslogStatus.setSectionG(this);
    }
}
