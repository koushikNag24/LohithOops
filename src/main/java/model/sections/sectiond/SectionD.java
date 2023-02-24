package model.sections.sectiond;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.sections.base.BaseIssues;
import model.sections.sectionh.StnLookAngle;

import java.util.List;
@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class SectionD extends BaseIssues {
    @OneToMany(mappedBy="sectionD")
    private List<SchemacsHealth> schemacsHealths;

    public SectionD(List<SchemacsHealth> schemacsHealths,String issues) {
        super(issues);
        this.schemacsHealths = schemacsHealths;
    }
    public void addSchemacsHealth(SchemacsHealth schemacsHealth){
        this.schemacsHealths.add(schemacsHealth);
        schemacsHealth.setSectionD(this);
    }
}
