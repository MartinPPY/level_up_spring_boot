package com.levelup.app.entities;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 7, max = 9)
    @NotBlank
    @Column(nullable = false, length = 9, unique = true)
    private String run;

    @Length(max = 50)
    @NotBlank
    @Column(nullable = false, length = 50)
    private String name;

    @Length(max = 100)
    @NotBlank
    @Column(nullable = false, length = 100)
    private String lastname;


    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @NotNull
    @Column(nullable = true)
    private LocalDate birthday;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    private Comuna comuna;

    @ManyToOne
    private Role role;

    public User() {
    }

    public User(String run, String name, String lastname, String email, LocalDate birthday, String password,
            Comuna comuna, Role role) {
        this.run = run;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthday = birthday;
        this.password = password;
        this.comuna = comuna;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
