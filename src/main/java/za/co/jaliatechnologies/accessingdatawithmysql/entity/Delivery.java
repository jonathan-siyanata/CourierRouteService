package za.co.jaliatechnologies.accessingdatawithmysql.entity;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Entity
@Table(name="Delivery")
@Configuration
public class Delivery {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="DELIVERY_ID", nullable = false)
    private Long delivery_id;

    @Column(name="ROUTE_ID", nullable = false)
    private Long route_id;

    @Column(name = "DRIVER_ID", nullable = false)
    private Long driver_id;

    @Column(name="DRIVER_ID_NUMBER", nullable = false)
    private String driver_id_number;

    @Column(name="DELIVERY_DATE", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String delivery_date;


    @Column(name="DELIVERY_TIME", nullable = false)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private String delivery_time;

    @Column(name="PRODUCT_TYPE", nullable = false)
    private String product_type;

    @Column(name="PRODUCT_QUANTITY", nullable = false)
    private Long product_quantity;

    @Column(name="ADDRESS", nullable = false)
    private String address;

    @Column(name="PRODUCT_ID", nullable = false)
    private Long product_id;

    @Column(name="ADDRESS_ID", nullable = false)
    private Long address_id;

    public Delivery(Long delivery_id, String driver_id_number, String delivery_date, String delivery_time, String product_type,
                    Long product_quantity, String address, Long driver_id, Long route_id, Long product_id, Long address_id) {
        this.delivery_id = delivery_id;
        this.driver_id_number = driver_id_number;
        this.delivery_date = delivery_date;
        this.delivery_time = delivery_time;
        this.product_type = product_type;
        this.product_quantity = product_quantity;
        this.address = address;
        this.driver_id = driver_id;
        this.route_id = route_id;
        this.product_id = product_id;
        this.address_id = address_id;
    }

    public Delivery(){
    }

    public Long getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(Long delivery_id) {
        this.delivery_id = delivery_id;
    }

    public String getDriver_id_number() {
        return driver_id_number;
    }

    public void setDriver_id_number(String driver_id_number) {
        this.driver_id_number = driver_id_number;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public Long getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(Long product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDelivery_date() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedString = localDate.format(formatter);
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(delivery_date);
        this.delivery_date = delivery_date;
    }

    public void setDelivery_time(String delivery_time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        LocalTime localTime = LocalTime.parse(delivery_time);
        this.delivery_time = delivery_time;
    }

    public String getDelivery_time() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        String formattedString = localTime.format(formatter);
        return delivery_time;
    }

    public Long getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Long driver_id) {
        this.driver_id = driver_id;
    }

    public Long getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Long route_id) {
        this.route_id = route_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }
}
