package model.sections.sectiond;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.Status;
import model.sections.base.BaseHealth;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class SchemacsHealth extends BaseHealth {


    private String issuesSchemacs;

    public SchemacsHealth(String name, Status status, String issuesSchemacs) {
        super(name, status);
        this.issuesSchemacs = issuesSchemacs;
    }
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "sectionD_Id")
    private SectionD sectionD;

    public void addSectionD(SectionD sectionD){
        this.setSectionD(sectionD);
        sectionD.addSchemacsHealth(this);
    }

}
