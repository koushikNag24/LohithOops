package model.sections.sectionb.archival.good;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public abstract class ArchivalBaseClass {

    private final String Status;
    private final String Size;

    public ArchivalBaseClass(String status, String size) {
        this.Status = status;
        this.Size = size;
    }
}
