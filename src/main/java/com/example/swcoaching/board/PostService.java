package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
        Post findById(long id);
        List<Post> PostInBoard(long id);

        Long savePost(Post post, long id);

        void deletePost(Long id);

        void updatePost(Post post);

        Page<PostEntity> pageList(Pageable pageable);
}
