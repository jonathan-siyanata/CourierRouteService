package za.co.jaliatechnologies.accessingdatawithmysql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.RouteEntity;

import java.util.List;

@Repository
public interface RouteDao extends JpaRepository<RouteEntity, Long> {

}
