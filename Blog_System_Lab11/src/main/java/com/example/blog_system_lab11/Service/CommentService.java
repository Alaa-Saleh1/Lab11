package com.example.blog_system_lab11.Service;

import com.example.blog_system_lab11.ApiResponse.ApiException;
import com.example.blog_system_lab11.Model.Comment;
import com.example.blog_system_lab11.Model.Post;
import com.example.blog_system_lab11.Model.User;
import com.example.blog_system_lab11.Repository.CommentRepository;
import com.example.blog_system_lab11.Repository.PostRepository;
import com.example.blog_system_lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }



    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public void addComment(Comment comment) {
        User user = userRepository.findUserById(comment.getUserId());
        Post post = postRepository.findPostById(comment.getPostId());
        if (user==null) {
            throw new ApiException("user not found");
        }
        if (post==null) {
            throw new ApiException("post not found");
        }
        comment.setCommentDate(LocalDate.now());
        commentRepository.save(comment);
    }
    public void updateComment(Integer id, Comment comment) {
        Comment oldComment = commentRepository.findCommentById(id);
        User user = userRepository.findUserById(comment.getUserId());
        Post post = postRepository.findPostById(comment.getPostId());
        if (oldComment==null) {
            throw new ApiException("comment not found");
        }
        if (user==null) {
            throw new ApiException("user not found");
        }
        if (post==null) {
            throw new ApiException("post not found");
        }

        oldComment.setPostId(comment.getPostId());
        oldComment.setContent(comment.getContent());
        oldComment.setUserId(comment.getUserId());
        commentRepository.save(oldComment);
    }

    public void deleteComment(Integer id) {
        Comment oldComment = commentRepository.findCommentById(id);
        if (oldComment==null) {
            throw new ApiException("comment not found");
        }
        commentRepository.delete(oldComment);
    }


    public List<Comment> findAllCommentsForPost(Integer postId) {
        return commentRepository.findAllCommentsForPost(postId);
    }

    public List<Comment> getCommentsBeforeDate(LocalDate date) {
        return commentRepository.getCommentsBeforeDate(date);
    }
}
