package model.sections.sectionb.measurements;

import lombok.ToString;
import tutorial.dao.utils.jpahibernate.model.enumer.IrimsChain;
import tutorial.dao.utils.jpahibernate.model.enumer.IrimsMode1;
import tutorial.dao.utils.jpahibernate.model.enumer.NavigationServer;

@ToString
public class UserPosition extends  BaseMeasurement{

    private String test;
    public UserPosition(NavigationServer server, IrimsMode1 location, Double value, IrimsChain chain, String test) {
        super(server, location, value, chain);
        this.test=test;
    }
}
