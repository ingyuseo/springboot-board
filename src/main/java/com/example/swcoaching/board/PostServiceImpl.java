package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.PostEntity;
import com.example.swcoaching.board.jpa.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Post findById(long id) {
        return postRepository.findById(id)
                .map(Post::of)
                .orElseThrow(() -> new BoardNotFoundException(id));
    }
    @Transactional
    public List<Post> PostInBoard(long id){
        List<Post> Posts = new ArrayList<>();
        for(PostEntity e :  postRepository.findByboardId(id))
        {
            Posts.add(Post.of(e));
        }
        return Posts;
    }



}