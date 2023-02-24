package model.sections.sectiond;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.Status;
import model.sections.base.BaseHealth;
import model.sections.sectionh.SectionH;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class SchemacsHealth extends BaseHealth {


    private String issues;
    @ManyToOne
    private SectionD sectionD;

    public SchemacsHealth(String name, Status status, String issues) {
        super(name, status);
        this.issues = issues;
    }
    public void addSectionD(SectionD sectionD){
        this.setSectionD(sectionD);
        sectionD.addSchemacsHealth(this);
    }
}
