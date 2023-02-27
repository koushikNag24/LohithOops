package model.sections.sectionc;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.sections.base.BaseValue;
@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class TwstftOffset extends BaseValue {
    private String issues;

    public TwstftOffset(String name, Double value, String issues) {
        super(name, value);
        this.issues = issues;
    }
}
