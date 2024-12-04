package com.example.blog_system_lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "category name cannot be empty")
    @Size(min = 4, message = "category name must be more than 4 characters")
    @Column(columnDefinition = "varchar(18) not null unique")
    private String name;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotEmpty(message = "category name cannot be empty") @Size(min = 4, message = "category name must be more than 4 characters") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "category name cannot be empty") @Size(min = 4, message = "category name must be more than 4 characters") String name) {
        this.name = name;
    }
}
