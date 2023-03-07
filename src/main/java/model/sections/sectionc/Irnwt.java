package model.sections.sectionc;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.Status;
import model.enumer.Names;
import model.sections.base.BaseHealth;
import model.sections.sectionh.SectionH;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class Irnwt extends BaseHealth {

    @ManyToOne
    private SectionC sectionC;

    private String issue;
    public Irnwt(Names name, Status status, String issue) {
        super(name, status, issue);

    }
    public void addSectionC(SectionC sectionC){
        this.setSectionC(sectionC);
        sectionC.addIrnwt(this);
    }


}