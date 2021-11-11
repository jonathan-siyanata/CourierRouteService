package za.co.jaliatechnologies.accessingdatawithmysql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Long> {

    @Query(value = "select address from Address address where" +
            " address.address = :address")
    Address findByAddress(@Param("address") String address);

}
