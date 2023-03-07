package model.sections.sectionb.measurements;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.enumer.IrimsMode1Stn;
import model.enumer.Servers;

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

    @Enumerated(EnumType.STRING)
    private Servers server;
    @Enumerated(EnumType.STRING)
    private IrimsMode1Stn location;

    private Double value;


    protected BaseMeasurement(Servers server, IrimsMode1Stn location, Double value) {
        this.server = server;
        this.location = location;
        this.value = value;

    }


}
