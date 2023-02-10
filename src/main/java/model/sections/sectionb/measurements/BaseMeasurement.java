package model.sections.sectionb.measurements;

import lombok.Getter;
import lombok.ToString;
@Getter
@ToString
public abstract class BaseMeasurement {
    private final String server;
    private final String location;
    private final Double value;
    private final Character chain;

    protected BaseMeasurement(String server, String location, Double value, Character chain) {
        this.server = server;
        this.location = location;
        this.value = value;
        this.chain = chain;
    }
}
