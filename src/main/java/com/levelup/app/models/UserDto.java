package com.levelup.app.models;

public class UserDto {

    private String run;
    private String name;
    private String lastname;
    private String email;
    private String birthday;
    private String password;
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
