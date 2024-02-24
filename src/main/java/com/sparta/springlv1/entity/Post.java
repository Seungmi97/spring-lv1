package com.sparta.springlv1.entity;

import com.sparta.springlv1.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "post")
@NoArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false, length = 50)
    private String title;
    @Column(name = "author", nullable = false, length = 20)
    private String author;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;
    @Column(name = "password", nullable = false, length = 20)
    private String password;

    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }

    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.contents = requestDto.getContents();
    }
}
