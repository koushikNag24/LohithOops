package model.sections.sectionb.measurements;

import lombok.ToString;

@ToString
public class UserPosition extends  BaseMeasurement{

    private String test;
    public UserPosition(String server, String location, Double value, Character chain,String test) {
        super(server, location, value, chain);
        this.test=test;
    }
}
