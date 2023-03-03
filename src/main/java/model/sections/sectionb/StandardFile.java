package model.sections.sectionb;

import jakarta.persistence.*;
import lombok.*;
import model.sections.sectionh.SectionH;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@AllArgsConstructor

public class StandardFile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "StandardFilesStatusIdSeq")
    @SequenceGenerator(name = "StandardFilesStatusIdSeq",sequenceName = "StandardFilesStatusIdSeqLearn",allocationSize = 1)
    @Column(name = "StandardFilesStatusIdSeq",updatable = false, nullable = false)
    private Long id;


    private String fileName;

    @ManyToOne
    private StandardFileStatus standardFileStatus;

    public StandardFile(String fileName) {
        this.fileName = fileName;
    }

    public void addStandardFileStatus(StandardFileStatus standardFileStatus){
        this.setStandardFileStatus(standardFileStatus);
        standardFileStatus.addStandardFile(this);
    }
}
