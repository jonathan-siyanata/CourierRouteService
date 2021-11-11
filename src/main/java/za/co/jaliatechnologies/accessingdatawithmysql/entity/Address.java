package za.co.jaliatechnologies.accessingdatawithmysql.entity;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@Entity
@Table(name="Address")
@Configuration
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ADDRESS_ID", nullable = false)
    private Long address_id;

    @Column(name="ADDRESS", nullable = false)
    private String address;

    @Column(name="LNG", nullable = false)
    private Double lng;

    @Column(name="LAT", nullable = false)
    private Double lat;

    public Address(Long address_id, String address, Double lng, Double lat) {
        this.address_id = address_id;
        this.address = address;
        this.lng = lng;
        this.lat = lat;
    }

    public Address() {
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public Double getLng() {
        return lng;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLat() {
        return lat;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
