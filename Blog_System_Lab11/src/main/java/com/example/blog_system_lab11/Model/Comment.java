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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "user Id cannot be null")
    @Positive(message = "user Id must be Integer")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @NotNull(message = "post Id cannot be null")
    @Positive(message = "post Id must be Integer")
    @Column(columnDefinition = "int not null")
    private Integer postId;

    @NotEmpty(message = "content cannot be empty")
    @Column(columnDefinition = "varchar(250) not null")
    private String content;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE", insertable = false, updatable = false)
    private LocalDate commentDate;


    public Comment(Integer id, Integer userId, Integer postId, String content, LocalDate commentDate) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.content = content;
        this.commentDate = commentDate;
    }

    public Comment() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "user Id cannot be null") @Positive(message = "user Id must be Integer") Integer getUserId() {
        return userId;
    }

    public void setUserId(@NotNull(message = "user Id cannot be null") @Positive(message = "user Id must be Integer") Integer userId) {
        this.userId = userId;
    }

    public @NotNull(message = "post Id cannot be null") @Positive(message = "post Id must be Integer") Integer getPostId() {
        return postId;
    }

    public void setPostId(@NotNull(message = "post Id cannot be null") @Positive(message = "post Id must be Integer") Integer postId) {
        this.postId = postId;
    }

    public @NotEmpty(message = "content cannot be empty") String getContent() {
        return content;
    }

    public void setContent(@NotEmpty(message = "content cannot be empty") String content) {
        this.content = content;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }
}
