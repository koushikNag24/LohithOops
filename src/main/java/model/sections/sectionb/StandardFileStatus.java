package model.sections.sectionb;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity

public class StandardFileStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "StandardFilesStatusIdSeq")
    @SequenceGenerator(name = "StandardFilesStatusIdSeq",sequenceName = "StandardFilesStatusIdSeqLearn",allocationSize = 1)
    @Column(name = "StandardFilesStatusIdSeq",updatable = false, nullable = false)
    private Long id;

    @OneToOne
    private SectionB sectionB;

    @OneToMany(mappedBy="standardFileStatus", cascade = CascadeType.ALL)
    private Set<StandardFile> availableDocuments = new HashSet<>();

    public StandardFileStatus(Set<StandardFile> availableDocuments) {
        this.availableDocuments =  availableDocuments;
    }
    public void addStandardFile(StandardFile standardFile){
        this.availableDocuments.add(standardFile);
        standardFile.setStandardFileStatus(this);
    }
}
