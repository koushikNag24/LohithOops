package model.sections.sectionc;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.Status;
import model.sections.base.BaseHealth;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class ParallelChain extends BaseHealth {

    private String issue;
    public ParallelChain(String name, Status status, String issue) {
        super(name, status, issue);

    }


}
