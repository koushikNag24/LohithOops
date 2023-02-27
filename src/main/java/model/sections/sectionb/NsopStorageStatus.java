package model.sections.sectionb;

import jakarta.transaction.Status;
import lombok.ToString;


@ToString

public class NsopStorageStatus {
    private final String name;
    private final Status status;


    public NsopStorageStatus(String name, Status status) {
        this.name = name;
        this.status = status;
    }
}
