package za.co.jaliatechnologies.accessingdatawithmysql.entity;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@Entity
@Table(name="Route")
@Configuration
public class RouteEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ROUTE_ID", nullable = false)
    private Long route_id;

    @Column(name="ROUTE_DESCRIPTION", nullable = false)
    private String route_description;

    public RouteEntity(Long route_id, String route_description) {
        this.route_id = route_id;
        this.route_description = route_description;
    }

    public RouteEntity(String route_description) {
      //  this.route_id = route_id;
        this.route_description = route_description;
    }

    public RouteEntity() {
    }

    public Long getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Long route_id) {
        this.route_id = route_id;
    }

    public String getRoute_description() {
        return route_description;
    }

    public void setRoute_description(String route_description) {
        this.route_description = route_description;
    }
}
