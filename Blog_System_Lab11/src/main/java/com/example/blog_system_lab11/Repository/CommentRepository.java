package com.example.blog_system_lab11.Repository;

import com.example.blog_system_lab11.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Comment findCommentById(Integer id);

    @Query("select c from Comment c where c.postId=?1")
    List<Comment> findAllCommentsForPost(Integer id);

    @Query("select c from Comment c where c.commentDate < ?1")
    List<Comment> getCommentsBeforeDate(LocalDate date);

}
