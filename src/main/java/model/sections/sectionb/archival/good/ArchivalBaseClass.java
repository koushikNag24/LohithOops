package model.sections.sectionb.archival.good;

import lombok.Getter;
import lombok.ToString;
import model.Status;

@ToString
@Getter
public abstract class ArchivalBaseClass {

    private final Status Status;
    private final String Size;

    public ArchivalBaseClass(Status status, String size) {
        this.Status = status;
        this.Size = size;
    }
}
