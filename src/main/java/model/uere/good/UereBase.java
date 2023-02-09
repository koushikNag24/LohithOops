package model.uere.good;

import lombok.ToString;

@ToString

public abstract class UereBase {
    private final Double value;
    private final String satellite;

    public UereBase(Double value, String satellite) {
        this.value = value;
        this.satellite = satellite;
    }
}
