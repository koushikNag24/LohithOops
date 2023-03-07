package model.sections.sectiond;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.Status;
import model.enumer.Names;
import model.sections.base.BaseHealth;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class SchemacsHealth extends BaseHealth {




    public SchemacsHealth(Names name, Status status, String issues) {
        super(name, status, issues);

    }
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "sectionD_Id")
    private SectionD sectionD;

    public void addSectionD(SectionD sectionD){
        this.setSectionD(sectionD);
        sectionD.addSchemacsHealth(this);
    }

}
