package tutorial.dao.utils.jpahibernate.model.inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
//@DiscriminatorValue("schemacs_health")
public class SchemacsHealthNew extends BaseHealthNew {
    private  String issues;

    public SchemacsHealthNew(Long id, String name, String status, String issues) {
        super(id,name, status);
        this.issues = issues;
    }
}
