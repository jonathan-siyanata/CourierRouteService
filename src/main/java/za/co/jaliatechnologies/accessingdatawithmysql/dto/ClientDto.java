package za.co.jaliatechnologies.accessingdatawithmysql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClientDto {

    private Long client_id;
    private String client_id_number;
    private String first_name;
    private String last_name;
    private String date_of_birth;
    private String email_address;
    private String phone_number;
    private Long address_id;

    public ClientDto(Long client_id, String client_id_number, String first_name, String last_name,
                     String date_of_birth, String email_address, String phone_number, Long address_id) {
        this.client_id = client_id;
        this.client_id_number = client_id_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.email_address = email_address;
        this.phone_number = phone_number;
        this .address_id = address_id;

    }

    public ClientDto() {
    }

    @JsonProperty("client_id")
    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    @JsonProperty("client_id_number")
    public String getClient_id_number() {
        return client_id_number;
    }

    public void setClient_id_number(String client_id_number) {
        this.client_id_number = client_id_number;
    }

    @JsonProperty("first_name")
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @JsonProperty("last_name")
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @JsonProperty("date_of_birth")
    public String getDate_of_birth() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedString = localDate.format(formatter);
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date_of_birth);
        this.date_of_birth = date_of_birth;
    }

    @JsonProperty("email_address")
    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    @JsonProperty("phone_number")
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @JsonProperty("address_is")
    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }
}
