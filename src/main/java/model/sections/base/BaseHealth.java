package model.sections.base;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import model.Status;

public class BaseHealth {
    private final String name;
    private final Status status;

    public BaseHealth(String name, Status status) {
        this.name = name;
        this.status = status;
    }
}
