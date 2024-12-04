package com.example.blog_system_lab11.Controller;

import com.example.blog_system_lab11.ApiResponse.ApiResponse;
import com.example.blog_system_lab11.Model.Post;
import com.example.blog_system_lab11.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/api/v1/blog-system/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.status(200).body(posts);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPost(@RequestBody @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        postService.addPost(post);
        return ResponseEntity.status(200).body(new ApiResponse("Post added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Integer id,@RequestBody @Valid Post post,Errors errors ) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        postService.updatePost(id, post);
        return ResponseEntity.status(200).body(new ApiResponse("Post updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.status(200).body(new ApiResponse("Post deleted successfully"));
    }

    @GetMapping("/user/{userId}")
    public List<Post> getPostsByUserId(@PathVariable Integer userId) {
        return postService.getPostsByUserId(userId);
    }

    @GetMapping("/title/{title}")
    public Post getPostByTitle(@PathVariable String title) {
        return postService.getPostByTitle(title);
    }

    @GetMapping("/before-date/{date}")
    public List<Post> getPostsBeforeDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return postService.getPostsBeforeDate(localDate);
    }

    @GetMapping("/keyword/{keyword}")
    public List<Post> getPostsByKeyword(@PathVariable String keyword) {
        return postService.getPostsByKeyword(keyword);
    }

    @GetMapping("/latest/user/{userId}")
    public Post getLatestPostByUserId(@PathVariable Integer userId) {
        return postService.getLatestPostByUserId(userId);
    }

}
