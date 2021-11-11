package za.co.jaliatechnologies.accessingdatawithmysql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DeliveryDto {

    private Long route_id;

    private Long driver_id;

    private Long delivery_id;

    private Long product_id;

    private Long address_id;

    @JsonProperty("driver_id_number")
    private String driver_id_number;

    @JsonProperty("delivery_date")
    private String delivery_date;

    @JsonProperty("delivery_time")
    private String delivery_time;

    @JsonProperty("address")
    private String address;

    @JsonProperty("product_type")
    private String product_type;

    @JsonProperty("product_quantity")
    private Long product_quantity;

    private ProductDto productDto;
    private AddressDto addressDto;
    private DriverDto driverDto;

    public DeliveryDto(Long delivery_id, DriverDto driverDto, String delivery_date, String delivery_time, ProductDto productDto, AddressDto addressDto, String driver_id_number, String address, String product_type, Long product_quantity, Long route_id, Long driver_id, Long product_id, Long address_id) {
        this.delivery_id = delivery_id;
        this.delivery_date = delivery_date;
        this.delivery_time = delivery_time;
        this.addressDto = addressDto;
        this.productDto = productDto;
        this.driverDto = driverDto;
        this.driver_id_number = driver_id_number;
        this.address = address;
        this.product_type = product_type;
        this.product_quantity = product_quantity;
        this.route_id = route_id;
        this.driver_id = driver_id;
        this.product_id = product_id;
        this.address_id = address_id;
    }

    public DeliveryDto() {
    }

    public long getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(long delivery_id) {
        this.delivery_id = delivery_id;
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

    public String getDelivery_time() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedString = localTime.format(formatter);
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        this.delivery_time = delivery_time;
    }

    public ProductDto getProductDto() {
        return productDto;
    }


    public AddressDto getAddressDto() {
        return addressDto;
    }

    public DriverDto getDriverDto() {
        return driverDto;
    }

    public void setDriverDto(DriverDto driverDto) {
        this.driverDto = driverDto;
    }

    public String getDriver_id_number() {
        return driver_id_number;
    }

    public void setDriver_id_number(String driver_id_number) {
        this.driver_id_number = driver_id_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Long getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Long route_id) {
        this.route_id = route_id;
    }

    public Long getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Long driver_id) {
        this.driver_id = driver_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }
}
