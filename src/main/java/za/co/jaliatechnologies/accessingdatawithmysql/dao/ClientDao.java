package za.co.jaliatechnologies.accessingdatawithmysql.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.Client;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {


}