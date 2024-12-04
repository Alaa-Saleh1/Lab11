package com.example.blog_system_lab11.Repository;

import com.example.blog_system_lab11.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findPostById(Integer id);

    @Query("select p from Post p where p.userId=?1")
    List<Post> getPostByUserId(Integer id);

    @Query("select p from Post p where p.title=?1")
    Post getPostByTitle(String title);

    @Query("select p from Post p where p.publishDate<?1")
    List<Post> getPostsBeforeDate(LocalDate date);

    @Query("select p from Post p where p.content LIKE %:keyword%")
    List<Post> getPostsBykeyword(String keyword);

    @Query("select p from Post p where p.userId = ?1 order by p.publishDate desc")
    Post getLatestPostByUserId(Integer userId);

}
