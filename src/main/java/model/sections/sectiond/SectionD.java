package model.sections.sectiond;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.sections.base.BaseIssues;
import model.sections.sectionh.StnLookAngle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class SectionD extends BaseIssues {
    @OneToMany(mappedBy="sectionD", cascade = CascadeType.ALL)
    private Set<SchemacsHealth> schemacsHealths=new HashSet<>();

    public SectionD(Set<SchemacsHealth> schemacsHealths,String issues) {
        super(issues);
        this.schemacsHealths = schemacsHealths;
    }
    public void addSchemacsHealth(SchemacsHealth schemacsHealth){
        this.schemacsHealths.add(schemacsHealth);
        schemacsHealth.setSectionD(this);
    }
}
