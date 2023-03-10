package tutorial.dao.utils.jpahibernate.model.revision;

import org.hibernate.envers.RevisionListener;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

public class EmployeeRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object revision) {
        EmployeeRevision employeeRevision=(EmployeeRevision)revision;
        employeeRevision.setIpAddress(getIpAddress());
        employeeRevision.setUserName(System.getProperty("user.name")+"_"+ LocalDateTime.now().getSecond());

    }
    public InetAddress getIpAddress(){
        InetAddress IP= null;
        try {
            IP = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return IP;
    }
}
