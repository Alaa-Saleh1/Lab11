package com.example.blog_system_lab11.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "username cannot be empty")
    @Size(min = 4, message = "name must be more than 4 characters")
    @Column(columnDefinition = "varchar(18) not null unique")
    private String username;

    @NotEmpty(message = "password cannot be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String password;

    @Email(message = "email must be valid format")
    @NotEmpty(message = "email cannot be empty")
    @Column(columnDefinition = "varchar(40) not null unique")
    private String email;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE", insertable = false, updatable = false)
    private LocalDate registrationDate;

    public User(Integer id, String username, String password, String email, LocalDate registrationDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotEmpty(message = "username cannot be empty") @Size(min = 4, message = "name must be more than 4 characters") String getUsername() {
        return username;
    }

    public void setUsername(@NotEmpty(message = "username cannot be empty") @Size(min = 4, message = "name must be more than 4 characters") String username) {
        this.username = username;
    }

    public @NotEmpty(message = "password cannot be empty") String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty(message = "password cannot be empty") String password) {
        this.password = password;
    }

    public @Email(message = "email must be valid format") @NotEmpty(message = "email cannot be empty") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "email must be valid format") @NotEmpty(message = "email cannot be empty") String email) {
        this.email = email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
