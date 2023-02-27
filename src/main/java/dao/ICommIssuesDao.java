package dao;

import jakarta.persistence.EntityManager;
import model.sections.sectiona.CommunicationIssue;


public interface ICommIssuesDao {
     void save(CommunicationIssue communicationIssue, EntityManager entityManager);

}
