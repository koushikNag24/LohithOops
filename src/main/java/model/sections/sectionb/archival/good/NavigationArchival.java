package model.sections.sectionb.archival.good;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.Status;
import model.sections.sectionb.SectionB;

import java.util.List;
import java.util.Set;

@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
public class NavigationArchival extends ArchivalBaseClass{

    @ManyToOne
    private SectionB sectionB;
    public NavigationArchival(Status status, String size) {
        super(status, size);
    }
    public void addSectionB(SectionB sectionB){
        this.setSectionB(sectionB);
        sectionB.addNavigationArchival(this);
    }
}
