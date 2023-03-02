package model.sections.sectionc;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.sections.base.BaseValue;
@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class GnssOffset extends BaseValue {
    @ManyToOne
    private SectionC sectionC;

    private String issues;

    public GnssOffset(String name, Double value, String issues) {
        super(name, value);
        this.issues = issues;
    }
    public void addSectionC(SectionC sectionC){
        this.setSectionC(sectionC);
        sectionC.addGnssOffset(this);
    }
}
