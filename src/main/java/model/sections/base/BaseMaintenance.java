package model.sections.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.sections.sectione.Station;

import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseMaintenance extends BaseIssues {


    @OneToMany(mappedBy = "baseMaintenance",cascade = CascadeType.ALL)
    public Set<Station> stations=new HashSet<>();



    public BaseMaintenance(String issues, Set<Station> stations) {
        super(issues);
        this.stations = stations;
    }
    public void addStation(Station station){
        this.stations.add(station);
        station.setBaseMaintenance(this);
    }
}
