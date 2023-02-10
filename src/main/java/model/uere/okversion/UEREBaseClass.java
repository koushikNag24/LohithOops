package model.uere.okversion;

import lombok.ToString;

@ToString

public abstract class UEREBaseClass {
    private final String[][] dataUERE;

    protected UEREBaseClass(String[][] dataUERE) {
        this.dataUERE = dataUERE;
    }
}
