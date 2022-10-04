package com.week03.blog.service;

import com.week03.blog.domain.Post;
import com.week03.blog.dto.PasswordRequestDto;
import com.week03.blog.dto.PostRequestDto;
import com.week03.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    // find post by id
    @Transactional
    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Post ID does not exist")
        );
    }

    // check if password match --> Login attempt
    @Transactional
    public Boolean loginAttempt(Long id, PasswordRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Post ID does not exist")
        );
        return post.getPassword().equals(requestDto.getPassword());
    }

    // update post
    @Transactional
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Post ID does not exist")
        );
        post.update(requestDto);
        return post.getId();
    }

    // delete post
    @Transactional
    public Long deletePost(Long id) {
        postRepository.deleteById(id);
        return id;
    }
}
