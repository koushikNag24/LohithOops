package tutorial.dao.utils.jpahibernate.model.inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.sections.base.BaseHealth;
@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
//@DiscriminatorValue("new_health")
public class NewHealth extends BaseHealthNew {
    private  String problem;

    public NewHealth(Long id,String name, String status, String problem) {
        super(id,name, status);
        this.problem = problem;
    }
}
