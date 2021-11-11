package za.co.jaliatechnologies.accessingdatawithmysql.geocoding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SouthWestDto {

    @JsonProperty("lat")
    private double lat;

    @JsonProperty("lng")
    private double lng;

    public SouthWestDto(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public SouthWestDto() {
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
