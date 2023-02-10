package model.archival.good;

import lombok.ToString;

@ToString

public abstract class ArchivalBaseClass {

    private final String Status;
    private final String Size;

    public ArchivalBaseClass(String status, String size) {
        this.Status = status;
        this.Size = size;
    }
}
