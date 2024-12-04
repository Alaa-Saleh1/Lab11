package com.example.blog_system_lab11.Repository;

import com.example.blog_system_lab11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer userId);

    @Query("select distinct u from User u join Post p on u.id = p.userId")
    List<User> getUsersWithPosts();

}
