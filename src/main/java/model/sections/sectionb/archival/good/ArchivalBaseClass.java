package model.sections.sectionb.archival.good;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.Status;
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
    @Column(name = "ArchivalsIdSeq",updatable = false, nullable = false)
    private Long id;



    private Status status;
    private String Size;

    public ArchivalBaseClass(Status status, String size) {
        this.status = status;
        this.Size = size;
    }

}
