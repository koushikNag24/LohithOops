package model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
@Getter
@ToString
public class StorageStatus extends BaseStatus {
    private final String shiftOpsStorage;
    private final  NsopStorageStatus nsopStorage;


    public StorageStatus(String issues, String shiftOpsStorage, NsopStorageStatus nsopStorage) {
        super(issues);
        this.shiftOpsStorage = shiftOpsStorage;
        this.nsopStorage = nsopStorage;
    }
}
