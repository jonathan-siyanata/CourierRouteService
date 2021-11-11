package za.co.jaliatechnologies.accessingdatawithmysql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.Address;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.Delivery;

import java.util.List;


@Repository
public interface DeliveryDao extends JpaRepository<Delivery, Long> {

    @Query(value = "select delivery from Delivery delivery where" +
            " delivery.route_id = :route_id")
    List<Delivery> findDeliveriesByRouteId(@Param("route_id") Long route_id);

}
