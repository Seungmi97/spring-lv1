package com.sparta.springlv1.service;

import com.sparta.springlv1.dto.PostRequestDto;
import com.sparta.springlv1.dto.PostResponseDto;
import com.sparta.springlv1.entity.Post;
import com.sparta.springlv1.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponseDto createPost(PostRequestDto requestDto) {
        // RequestDto -> Entity
        Post post = new Post(requestDto);

        // DB 저장
        Post savePost = postRepository.save(post);

        // Entity -> ResponseDto
        PostResponseDto postResponseDto = new PostResponseDto(post);

        return postResponseDto;
    }

    public List<PostResponseDto> getPosts() {
        // DB 조회
        return postRepository.findAllByOrderByCreatedAtDesc().stream().map(PostResponseDto::new).toList();
    }

    public PostResponseDto getPostById(Long id) {
        // 해당 게시글이 DB에 존재하는지 확인
        Post post = findPost(id);

        return new PostResponseDto(post);
    }

    @Transactional
    public Long updatePost(Long id, PostRequestDto requestDto) {
        // 해당 게시글이 DB에 존재하는지 확인
        Post post = findPost(id);

        // post 내용 수정
        if (Objects.equals(post.getPassword(), requestDto.getPassword())) {
            post.update(requestDto);
        }

        return id;
    }

    public Long deletePost(Long id, PostRequestDto requestDto) {
        // 해당 게시글이 DB에 존재하는지 확인
        Post post = findPost(id);

        // post 삭제
        if (Objects.equals(post.getPassword(), requestDto.getPassword())) {
            postRepository.delete(post);
        }

        return id;
    }

    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다.")
        );
    }
}
