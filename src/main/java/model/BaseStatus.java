package model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public abstract class BaseStatus {
    private final String issues;

    public BaseStatus(String issues) {
        this.issues=issues;
    }
}
