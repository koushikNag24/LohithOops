package dao;

import jakarta.persistence.EntityManager;
import model.NavicPerformanceDetails;

public interface INavicPerformanceDao {
    void save(NavicPerformanceDetails navicPerformanceDetails, EntityManager entityManager);
}
