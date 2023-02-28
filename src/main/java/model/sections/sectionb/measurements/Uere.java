package model.sections.sectionb.measurements;

import lombok.Getter;
import tutorial.dao.utils.jpahibernate.model.enumer.IrimsChain;
import tutorial.dao.utils.jpahibernate.model.enumer.IrimsMode1;
import tutorial.dao.utils.jpahibernate.model.enumer.NavIC_Satellite;
import tutorial.dao.utils.jpahibernate.model.enumer.NavigationServer;

@Getter

public class Uere extends BaseMeasurement{
    private final NavIC_Satellite satellite;

    public Uere(NavigationServer server, IrimsMode1 location, Double value, IrimsChain chain, NavIC_Satellite satellite) {
        super(server, location, value, chain);
        this.satellite = satellite;
    }



}
