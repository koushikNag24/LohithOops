package model.sections.base;

import lombok.Getter;

@Getter
public class BaseHealth {
    private final String name;
    private final String status;

    public BaseHealth(String name, String status) {
        this.name = name;
        this.status = status;
    }
}
