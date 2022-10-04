package com.week03.blog.domain;

import com.week03.blog.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Post {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long id;
    private String title;
    private String author;
    private String password;

    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
    }

    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
    }
}
