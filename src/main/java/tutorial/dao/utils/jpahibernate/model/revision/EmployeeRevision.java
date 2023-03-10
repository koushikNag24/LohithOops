package tutorial.dao.utils.jpahibernate.model.revision;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import java.net.InetAddress;
@Getter
@Setter
@Entity(name = "EmployeeRevision")
@Table(name = "Employee_REVISION")
@RevisionEntity(EmployeeRevisionListener.class)
public class EmployeeRevision  extends DefaultRevisionEntity {
    private InetAddress  ipAddress;
    private String userName;
}
