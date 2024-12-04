package com.example.blog_system_lab11.Controller;

import com.example.blog_system_lab11.ApiResponse.ApiResponse;
import com.example.blog_system_lab11.Model.Comment;
import com.example.blog_system_lab11.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/blog-system/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllComments() {
        List<Comment> comments = commentService.getAllComments();
        return ResponseEntity.status(200).body(comments);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addComment(@RequestBody @Valid Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        commentService.addComment(comment);
        return ResponseEntity.status(200).body(new ApiResponse("Comment added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Integer id, @RequestBody @Valid Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        commentService.updateComment(id, comment);
        return ResponseEntity.status(200).body(new ApiResponse("Comment updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
        return ResponseEntity.status(200).body(new ApiResponse("Comment deleted successfully"));
    }

    @GetMapping("/post/{postId}")
    public List<Comment> findAllCommentsForPost(@PathVariable Integer postId) {
        return commentService.findAllCommentsForPost(postId);
    }

    @GetMapping("/before-date/{date}")
    public List<Comment> getCommentsBeforeDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return commentService.getCommentsBeforeDate(localDate);
    }
}
