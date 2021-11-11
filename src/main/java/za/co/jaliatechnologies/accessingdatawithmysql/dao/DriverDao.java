package za.co.jaliatechnologies.accessingdatawithmysql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.Driver;

@Repository
public interface DriverDao extends JpaRepository<Driver, Long> {

    @Query(value= "select driver from Driver driver where" +
            " driver.driver_id_number = :driver_id_number")
    Driver findDriverIdNumber(@Param("driver_id_number") String driver_id_number);
}
