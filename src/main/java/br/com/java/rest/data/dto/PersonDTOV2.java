package br.com.java.rest.data.dto;

import br.com.java.rest.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.*;
import tools.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonFilter("PersonFilter")
@JsonPropertyOrder(value = {"id", "firstName", "lastName", "gender"})
public class PersonDTOV2 implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date birthDay = new Date();
    @JsonProperty("ADDreSS")
    private String address;

    //@JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String phoneNumber="";
    @JsonSerialize(using = GenderSerializer.class)
    private String gender;
    private String password;


    public PersonDTOV2(String password, String gender, String address, String lastName, String firstName, Long id) {
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersonDTOV2{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
