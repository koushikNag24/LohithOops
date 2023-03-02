package model.sections.sectionb.measurements;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.enumer.IrimsChain;
import model.enumer.IrimsMode1Stn;
import model.sections.sectionb.SectionB;
import model.sections.sectionh.SectionH;

@Getter
@ToString
@Setter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "baseMeasurementIdSeq")
    @SequenceGenerator(name = "baseMeasurementIdSeq",sequenceName = "baseMeasurementIdlearn",allocationSize = 1)
    @Column(name = "baseMeasurementId",updatable = false, nullable = false)
    private Long id;

    private String server;
    private IrimsMode1Stn location;
    private Double value;
    private IrimsChain chain;

    protected BaseMeasurement(String server, IrimsMode1Stn location, Double value, IrimsChain chain) {
        this.server = server;
        this.location = location;
        this.value = value;
        this.chain = chain;
    }


}
