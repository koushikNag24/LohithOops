package model.sections.base;

import lombok.Getter;

@Getter
public class BaseValue {
    private final String name;
    private final Double value;

    public BaseValue(String name, Double value) {
        this.name = name;
        this.value = value;
    }
}
