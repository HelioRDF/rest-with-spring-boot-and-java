package br.com.java.rest.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import tools.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder(value = {"id","firstName","lastName","gender"})
public class PersonDTOV2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String firstName;
    private String lastName;
    @JsonProperty("ADreSS")
    private String address;
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
