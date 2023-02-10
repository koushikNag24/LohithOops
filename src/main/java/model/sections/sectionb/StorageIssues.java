package model.sections.sectionb;

import lombok.Getter;
import lombok.ToString;
import model.sections.base.BaseIssues;
import org.apache.log4j.Logger;

@Getter
@ToString
public class StorageIssues extends BaseIssues {

    final static Logger logger = Logger.getLogger(StorageIssues.class);
    private final String shiftOpsStorage;
    private final NsopStorageStatus nsopStorage;


    public StorageIssues(String issues, String shiftOpsStorage, NsopStorageStatus nsopStorage) {
        super(issues);
        this.shiftOpsStorage = shiftOpsStorage;
        this.nsopStorage = nsopStorage;
    }


}
