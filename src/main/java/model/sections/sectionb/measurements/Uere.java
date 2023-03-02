package model.sections.sectionb.measurements;

import lombok.Getter;
import model.enumer.IrimsChain;
import model.enumer.IrimsMode1Stn;
import model.sections.sectionb.Measurement;

@Getter

public class Uere extends Measurement {
    private final String satellite;

    public Uere(String server, IrimsMode1Stn location, Double value, IrimsChain chain, String satellite) {
        super(server, location, value, chain);
        this.satellite = satellite;
    }



}
