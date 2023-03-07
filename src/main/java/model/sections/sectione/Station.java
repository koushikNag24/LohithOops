package model.sections.sectione;

import jakarta.persistence.*;
import lombok.*;
import model.enumer.StationName;
import model.sections.base.BaseMaintenance;


@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@AllArgsConstructor

public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "StnNamesIdSeq")
    @SequenceGenerator(name = "StnNamesIdSeq",sequenceName = "StnNamesIdLearn",allocationSize = 1)
    @Column(name = "StnNameId",updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    private BaseMaintenance baseMaintenance;


    @Enumerated(EnumType.STRING)
    private StationName name;

    public Station(StationName name) {
        this.name = name;
    }



}
