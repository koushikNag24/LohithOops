package model.sections.sectionb;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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
    private Set<String> availableDocuments;

    public StandardFileStatus(Set<String> availableDocuments) {
        this.availableDocuments =  availableDocuments;
    }
}
