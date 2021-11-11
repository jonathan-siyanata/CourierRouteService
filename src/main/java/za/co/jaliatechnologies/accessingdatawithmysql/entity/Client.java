package za.co.jaliatechnologies.accessingdatawithmysql.entity;

import org.springframework.context.annotation.Configuration;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="Client")
@Configuration
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="CLIENT_ID", nullable = false)
    private Long client_id;

    @Column(name="CLIENT_ID_NUMBER", nullable = false)
    private String client_id_number;

    @Column(name="FIRST_NAME", nullable = false)
    private String first_name;

    @Column(name="LAST_NAME", nullable = false)
    private String last_name;

    @Column(name="DATE_OF_BIRTH", nullable = false)
    private String date_of_birth;

    @Column(name="EMAIL_ADDRESS", nullable = false)
    private String email_address;

    @Column(name="PHONE_NUMBER", nullable = false)
    private String phone_number;

    @Column(name="ADDRESS_ID", nullable = false)
    private Long address_id;

    public Client(Long client_id, String client_id_number, String first_name, String last_name, String date_of_birth,
                  String email_address, String phone_number, Long address_id) {
        this.client_id = client_id;
        this.client_id_number = client_id_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.email_address = email_address;
        this.phone_number = phone_number;
        this.address_id = address_id;
    }

    public Client() {
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getClient_id_number() {
        return client_id_number;
    }

    public void setClient_id_number(String client_id_number) {
        this.client_id_number = client_id_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDate_of_birth() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedString = localDate.format(formatter);
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date_of_birth);
        this.date_of_birth = date_of_birth;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }
}
