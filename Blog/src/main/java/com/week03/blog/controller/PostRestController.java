package com.week03.blog.controller;

import com.week03.blog.domain.Post;
import com.week03.blog.dto.PasswordRequestDto;
import com.week03.blog.dto.PostRequestDto;
import com.week03.blog.repository.PostRepository;
import com.week03.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostRestController {
    private final PostService postService;
    private final PostRepository postRepository;

    // Get all the posts
    @GetMapping("/api/posts")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Create new post
    @PostMapping("/api/write")
    public Post writePost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return post;
    }

    // Gets a post
    @GetMapping("/api/posts/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    // Login attempt
    @PostMapping("/api/posts/{id}")
    public Boolean loginAttempt(@PathVariable Long id, @RequestBody PasswordRequestDto requestDto) {
        return postService.loginAttempt(id, requestDto);
    }

    // Update post
    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        PasswordRequestDto passwordRequestDto = new PasswordRequestDto(requestDto.getPassword());
        if (loginAttempt(id, passwordRequestDto))
            return postService.update(id, requestDto);
        else return -1L;
    }

    // Delete post
    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }
}
