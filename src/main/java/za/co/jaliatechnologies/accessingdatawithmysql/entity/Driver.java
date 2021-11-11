package za.co.jaliatechnologies.accessingdatawithmysql.entity;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="Driver")
@Configuration
public class Driver {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="DRIVER_ID", nullable = false)
    private Long driver_id;

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

    @Column(name="DRIVER_ID_NUMBER", nullable = false)
    private String driver_id_number;

    @Column(name="PASSWORD", nullable = false)
    private String password;

    public Driver(Long driver_id, String first_name, String last_name, String date_of_birth, String email_address, String phone_number, String driver_id_number, String password) {
        this.driver_id = driver_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.email_address = email_address;
        this.phone_number = phone_number;
        this.driver_id_number = driver_id_number;
        this.password = password;
    }

    public Driver(){
    }

    public Long getDriver_id() {
          return driver_id;
    }
    public void setDriver_id(Long driver_id) {
        this.driver_id = driver_id;
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

    public String getDriver_id_number() {
        return driver_id_number;
    }

    public void setDriver_id_number(String driver_id_number) {
        this.driver_id_number = driver_id_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
