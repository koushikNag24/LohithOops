package model.sections.sectionb;

import lombok.ToString;

@ToString

public class NsopStorageStatus {
    private final String nsop1Storage;
    private final String nsop2Storage;


    public NsopStorageStatus(String nsop1Storage, String nsop2Storage) {
        this.nsop1Storage = nsop1Storage;
        this.nsop2Storage = nsop2Storage;
    }
}
