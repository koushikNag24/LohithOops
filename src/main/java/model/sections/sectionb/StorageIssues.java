package model.sections.sectionb;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.sections.base.BaseIssues;
import model.sections.sectionh.StnLookAngle;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Setter
public class StorageIssues extends BaseIssues {

    final static Logger logger = Logger.getLogger(StorageIssues.class);


    @OneToOne
    private SectionB sectionB;

    @OneToMany(mappedBy="storageStatus", cascade = CascadeType.ALL)
    private Set<NsopStorageStatus> nsopStorageSet = new HashSet<>();


    public StorageIssues(Set<NsopStorageStatus> nsopStorage, String issues) {
        super(issues);
        this.nsopStorageSet = nsopStorageSet;
    }

    public void addNsopStorageStatus(NsopStorageStatus nsopStorageStatus){
        this.nsopStorageSet.add(nsopStorageStatus);
        nsopStorageStatus.setStorageStatus(this);
    }

}
