package model.sections.sectionb.archival.good;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.Status;
import model.enumer.ArchivalName;
import model.sections.sectionb.SectionB;
import model.sections.sectionh.SectionH;

@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class ArchivalBaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ArchivalsIdSeq")
    @SequenceGenerator(name = "ArchivalsIdSeq",sequenceName = "ArchivalsIdLearn",allocationSize = 1)
    @Column(name = "ArchivalsId",updatable = false, nullable = false)
    private Long id;


    @Enumerated(EnumType.STRING)
    private ArchivalName name;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String Size;

    public ArchivalBaseClass(ArchivalName name, Status status, String size) {
        this.name=name;
        this.status = status;
        this.Size = size;
    }

}
