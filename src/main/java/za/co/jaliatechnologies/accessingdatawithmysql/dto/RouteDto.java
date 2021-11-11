package za.co.jaliatechnologies.accessingdatawithmysql.dto;

import java.util.List;

public class RouteDto {


    private Long route_id;
    private String route_description;
    private DeliveryDto deliveryDto;

    public RouteDto(Long route_id, String route_description, DeliveryDto deliveryDto) {
        this.route_id = route_id;
        this.route_description = route_description;
        this.deliveryDto = deliveryDto;
    }

    public RouteDto() {
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

    public DeliveryDto getDeliveryDto() {
        return deliveryDto;
    }

    public void setDeliveryDto(DeliveryDto deliveryDto) {
        this.deliveryDto = deliveryDto;
    }
}
