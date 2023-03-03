package model.sections.sectionb.measurements;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.enumer.IrimsChain;
import model.enumer.IrimsMode1Stn;
import model.enumer.Satellite;
import model.enumer.Servers;
import model.sections.sectionb.Measurement;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity

public class Uere extends Measurement {
    @Enumerated(EnumType.STRING)
    private Satellite satellite;

    @Enumerated(EnumType.STRING)
    private IrimsChain chain;

    public Uere(Servers server, IrimsMode1Stn location, Double value, IrimsChain chain, Satellite satellite ) {
        super(server, location, value);
        this.satellite = satellite;
        this.chain = chain;
    }



}
