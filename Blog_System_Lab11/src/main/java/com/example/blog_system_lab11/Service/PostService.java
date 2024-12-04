package com.example.blog_system_lab11.Service;

import com.example.blog_system_lab11.ApiResponse.ApiException;
import com.example.blog_system_lab11.Model.Category;
import com.example.blog_system_lab11.Model.Post;
import com.example.blog_system_lab11.Model.User;
import com.example.blog_system_lab11.Repository.CategoryRepository;
import com.example.blog_system_lab11.Repository.PostRepository;
import com.example.blog_system_lab11.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }


    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void addPost(Post post) {
        User user = userRepository.findUserById(post.getUserId());
        if (user == null) {
            throw new ApiException("User not found");
        }
        Category category = categoryRepository.findCategoryById(post.getCategoryId());
        if (category == null) {
            throw new ApiException("Category not found");
        }

        post.setPublishDate(LocalDate.now());
        postRepository.save(post);
    }

    public void updatePost(Integer id , Post post) {
        Post oldPost = postRepository.findPostById(id);
        if (oldPost == null) {
            throw new ApiException("post not found");
        }
        User user = userRepository.findUserById(post.getUserId());
        if (user == null) {
            throw new ApiException("User not found");
        }
        Category category = categoryRepository.findCategoryById(post.getCategoryId());
        if (category == null) {
            throw new ApiException("Category not found");
        }

        oldPost.setCategoryId(post.getCategoryId());
        oldPost.setTitle(post.getTitle());
        oldPost.setContent(post.getContent());
        oldPost.setUserId(post.getUserId());
        postRepository.save(oldPost);
    }
    public void deletePost(Integer id) {
        Post post = postRepository.findPostById(id);
        if (post == null) {
            throw new ApiException("post not found");
        }
        postRepository.delete(post);
    }

    public List<Post> getPostsByUserId(Integer userId) {
        return postRepository.getPostByUserId(userId);
    }

    public Post getPostByTitle(String title) {
        return postRepository.getPostByTitle(title);
    }


    public List<Post> getPostsBeforeDate(LocalDate date) {
        return postRepository.getPostsBeforeDate(date);
    }


    public List<Post> getPostsByKeyword(String keyword) {
        return postRepository.getPostsBykeyword(keyword);
    }

    public Post getLatestPostByUserId(Integer userId) {
        return postRepository.getLatestPostByUserId(userId);
    }
}
