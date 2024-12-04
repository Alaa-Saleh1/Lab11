package com.example.blog_system_lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "category Id cannot be null")
    @Positive(message = "category Id must be Integer")
    @Column(columnDefinition = "int not null")
    private Integer categoryId;

    @NotEmpty (message = "title cannot be empty")
    @Column(columnDefinition = "varchar(60) not null unique")
    private String title;

    @NotEmpty (message = "content cannot be empty")
    @Column(columnDefinition = "varchar(250) not null")
    private String content;

    @NotNull(message = "user Id cannot be null")
    @Positive(message = "user Id must be Integer")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE", insertable = false, updatable = false)
    private LocalDate publishDate;


    public Post(Integer id, Integer categoryId, String title, String content, Integer userId, LocalDate publishDate) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.publishDate = publishDate;
    }

    public Post() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "category Id cannot be null") @Positive(message = "category Id must be Integer") Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@NotNull(message = "category Id cannot be null") @Positive(message = "category Id must be Integer") Integer categoryId) {
        this.categoryId = categoryId;
    }

    public @NotEmpty(message = "title cannot be empty") String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty(message = "title cannot be empty") String title) {
        this.title = title;
    }

    public @NotEmpty(message = "content cannot be empty") String getContent() {
        return content;
    }

    public void setContent(@NotEmpty(message = "content cannot be empty") String content) {
        this.content = content;
    }

    public @NotNull(message = "user Id cannot be null") @Positive(message = "user Id must be Integer") Integer getUserId() {
        return userId;
    }

    public void setUserId(@NotNull(message = "user Id cannot be null") @Positive(message = "user Id must be Integer") Integer userId) {
        this.userId = userId;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

}
