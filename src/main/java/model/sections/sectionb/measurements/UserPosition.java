package model.sections.sectionb.measurements;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.enumer.IrimsChain;
import model.enumer.IrimsMode1Stn;
import model.enumer.Servers;
import model.sections.sectionb.Measurement;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class UserPosition extends Measurement {


    public UserPosition(Servers server, IrimsMode1Stn location, Double value) {
        super(server, location, value);

    }


}
