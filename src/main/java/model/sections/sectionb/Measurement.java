package model.sections.sectionb;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.enumer.IrimsChain;
import model.enumer.IrimsMode1Stn;
import model.sections.sectionb.measurements.BaseMeasurement;
@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor

public class Measurement extends BaseMeasurement {
    @ManyToOne
    @JoinColumn(name="measurement_sectionB")
    private SectionB sectionB;
    public Measurement(String server, IrimsMode1Stn location, Double value, IrimsChain chain) {
        super(server, location, value, chain);

    }
    public void addSectionB(SectionB sectionB){
        this.setSectionB(sectionB);
        sectionB.addMeasurements(this);
    }
}
