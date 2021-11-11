package za.co.jaliatechnologies.accessingdatawithmysql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AddressDto {

    private Long address_id;

    @JsonProperty("address")
    private String address;

    private Double lng;
     private Double lat;

    public AddressDto(Long address_id, String address, Double lng, Double lat) {
        this.address_id = address_id;
        this.address = address;
        this.lng = lng;
        this.lat = lat;
    }

    public AddressDto() {
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
