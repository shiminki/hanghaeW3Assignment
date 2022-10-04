package com.week03.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostRequestDto {
    private String title;
    private String author;
    private String password;

    public PostRequestDto(JSONObject itemJson) {
        this.title = itemJson.getString("title");
        this.author = itemJson.getString("author");
        this.password = itemJson.getString("password");
    }

}
