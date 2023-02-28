package model.sections.sectionb;

import jakarta.persistence.*;
import jakarta.transaction.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.sections.sectionh.SectionH;


@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity

public class NsopStorageStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "nsopStorageStatus_seq")
    @SequenceGenerator(name = "nsopStorageStatus_seq",sequenceName = "nsopStorageStatus_learn",allocationSize = 3)
    @Column(name = "nsopStorageStatus_id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="base_issue_id ") //Issue in this line, I guess
    private StorageIssues storageStatus;
    private  String name;
    private  Status status;


    public NsopStorageStatus(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    public void addStorageStatus(StorageIssues storageStatus){
        this.setStorageStatus(storageStatus);
        storageStatus.addNsopStorageStatus(this);
    }
}
