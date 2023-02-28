package model.sections.sectionb.measurements;

import lombok.Getter;
import lombok.ToString;
import tutorial.dao.utils.jpahibernate.model.enumer.IrimsChain;
import tutorial.dao.utils.jpahibernate.model.enumer.IrimsMode1;
import tutorial.dao.utils.jpahibernate.model.enumer.NavigationServer;

@Getter
@ToString
public abstract class BaseMeasurement {
    private final NavigationServer server;
    private final IrimsMode1 location;
    private final Double value;
    private final IrimsChain chain;

    protected BaseMeasurement(NavigationServer server, IrimsMode1 location, Double value, IrimsChain chain) {
        this.server = server;
        this.location = location;
        this.value = value;
        this.chain = chain;
    }
}
