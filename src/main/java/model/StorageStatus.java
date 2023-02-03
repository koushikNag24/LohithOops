package model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.apache.log4j.Logger;

@Getter
@ToString
public class StorageStatus extends BaseStatus {

    final static Logger logger = Logger.getLogger(StorageStatus.class);
    private final String shiftOpsStorage;
    private final  NsopStorageStatus nsopStorage;


    public StorageStatus(String issues, String shiftOpsStorage, NsopStorageStatus nsopStorage) {
        super(issues);
        this.shiftOpsStorage = shiftOpsStorage;
        this.nsopStorage = nsopStorage;
    }


}
