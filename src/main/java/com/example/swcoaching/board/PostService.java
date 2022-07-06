package com.example.swcoaching.board;

import java.util.List;

public interface PostService {
        Post findById(long id);
        List<Post> PostInBoard(long id);

        Long savePost(Post post, Board board);
}
