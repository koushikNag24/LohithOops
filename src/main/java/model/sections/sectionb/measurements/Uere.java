package model.sections.sectionb.measurements;

import lombok.Getter;

@Getter

public class Uere extends BaseMeasurement{
    private final String satellite;

    public Uere(String server, String location, Double value, Character chain, String satellite) {
        super(server, location, value, chain);
        this.satellite = satellite;
    }



}
