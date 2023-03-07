package model.sections.sectiong;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.NavicPerformanceDetails;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class SectionG  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "secG")
    @SequenceGenerator(name = "secG",sequenceName = "secGSeq",allocationSize = 1)
    private Long id;

    @OneToOne(mappedBy = "sectionG",cascade = CascadeType.ALL)
    private  SyslogStatus syslogStatus;

    @OneToOne(mappedBy = "sectionG",cascade = CascadeType.ALL)
    private NavicPerformanceDetails navicPerformanceDetails;


    public SectionG(SyslogStatus syslogStatus) {
        this.syslogStatus = syslogStatus;
    }
    public void addSysLog(SyslogStatus syslogStatus){
        this.setSyslogStatus(syslogStatus);
        syslogStatus.setSectionG(this);
    }

}
