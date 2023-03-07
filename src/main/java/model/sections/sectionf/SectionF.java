package model.sections.sectionf;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.NavicPerformanceDetails;
import model.sections.base.BaseMaintenance;


@ToString
@NoArgsConstructor
@Getter
@Entity
@Setter

public class SectionF extends BaseMaintenance {

    @OneToOne(mappedBy = "sectionF",cascade = CascadeType.ALL)
    private NavicPerformanceDetails navicPerformanceDetails;


}
