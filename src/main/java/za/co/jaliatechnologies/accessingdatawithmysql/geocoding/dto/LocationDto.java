package za.co.jaliatechnologies.accessingdatawithmysql.geocoding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationDto {

    @JsonProperty("lat")
    private double lat;

    @JsonProperty("lng")
    private double lng;

    public LocationDto(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public LocationDto() {
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
