package com.sparta.springlv1.dto;

import com.sparta.springlv1.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String author;
    private String contents;
    private LocalDateTime createdAt;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.contents = post.getContents();
        this.createdAt = post.getCreatedAt();
    }
}
