package com.levelup.app.models.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserDto {

    @Length(min = 7, max = 9)
    @NotBlank
    private String run;

    @Length(max = 50)
    @NotBlank
    private String name;

    @Length(max = 100)
    @NotBlank
    private String lastname;

    @Length(max = 100)
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@(gmail\\.com|duoc\\.cl|duocuc\\.cl)$", message = "Solo se permiten correos gmail.com, duoc.cl o duocuc.cl")
    private String email;

    @NotBlank
    private String birthday;

    @Length(max = 10,min = 4)
    @NotBlank
    private String password;

    @NotNull
    private Integer comunaId;

    private Integer role;

    public UserDto(String run, String name, String lastname, String email, String birthday, String password,
            Integer comunaId, Integer role) {
        this.run = run;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthday = birthday;
        this.password = password;
        this.comunaId = comunaId;
        this.role = role;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Length(max = 100)
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@(gmail\\.com|duoc\\.cl|duocuc\\.cl)$", message = "Solo se permiten correos gmail.com, duoc.cl o duocuc.cl")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getComunaId() {
        return comunaId;
    }

    public void setComunaId(Integer comunaId) {
        this.comunaId = comunaId;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

}
