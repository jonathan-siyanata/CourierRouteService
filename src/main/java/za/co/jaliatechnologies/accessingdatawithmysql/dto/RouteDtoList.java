package za.co.jaliatechnologies.accessingdatawithmysql.dto;

import java.util.List;

public class RouteDtoList {

    private List<DeliveryDto> routeDtoList;

    public RouteDtoList(List<DeliveryDto> routeDtoList) {
        this.routeDtoList = routeDtoList;
    }

    public RouteDtoList() {
    }

    public List<DeliveryDto> getRouteDtoList() {
        return routeDtoList;
    }

    public void setRouteDtoList(List<DeliveryDto> routeDtoList) {
        this.routeDtoList = routeDtoList;
    }

}
