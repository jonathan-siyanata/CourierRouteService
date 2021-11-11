package za.co.jaliatechnologies.accessingdatawithmysql.algorithms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.Entity.AlgorithmType;

@Repository
public interface AlgorithmTypeDao extends JpaRepository<AlgorithmType, Long> {
}
