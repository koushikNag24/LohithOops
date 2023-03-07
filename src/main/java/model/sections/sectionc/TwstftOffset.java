package model.sections.sectionc;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.enumer.Names;
import model.sections.base.BaseValue;
@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class TwstftOffset extends BaseValue {
    @ManyToOne
    private SectionC sectionC;

    private String issues;

    public TwstftOffset(Names name, Double value, String issues) {
        super(name, value);
        this.issues = issues;
    }
    public void addSectionC(SectionC sectionC){
        this.setSectionC(sectionC);
        sectionC.addTwstftOffset(this);
    }
}
