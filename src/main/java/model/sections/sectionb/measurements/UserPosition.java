package model.sections.sectionb.measurements;

import lombok.ToString;
import model.enumer.IrimsChain;
import model.enumer.IrimsMode1Stn;
import model.sections.sectionb.Measurement;

@ToString
public class UserPosition extends Measurement {


    public UserPosition(String server, IrimsMode1Stn location, Double value, IrimsChain chain) {
        super(server, location, value, chain);

    }


}
