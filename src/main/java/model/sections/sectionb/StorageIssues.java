package model.sections.sectionb;

import lombok.Getter;
import lombok.ToString;
import model.sections.base.BaseIssues;
import org.apache.log4j.Logger;

import java.util.List;

@Getter
@ToString
public class StorageIssues extends BaseIssues {

    final static Logger logger = Logger.getLogger(StorageIssues.class);



    private final List<NsopStorageStatus> nsopStorage;


    public StorageIssues(List<NsopStorageStatus> nsopStorage, String issues) {
        super(issues);
        this.nsopStorage = nsopStorage;
    }
}
