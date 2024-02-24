package com.sparta.springlv1.controller;

import com.sparta.springlv1.dto.PostRequestDto;
import com.sparta.springlv1.dto.PostResponseDto;
import com.sparta.springlv1.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    @GetMapping("/post")
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/post/{id}")
    public PostResponseDto getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PutMapping("/post/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.updatePost(id, requestDto);
    }

    @DeleteMapping("/post/{id}")
    public Long deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.deletePost(id, requestDto);
    }
}
