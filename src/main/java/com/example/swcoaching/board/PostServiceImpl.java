package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.BoardEntity;
import com.example.swcoaching.board.jpa.BoardRepository;
import com.example.swcoaching.board.jpa.PostEntity;
import com.example.swcoaching.board.jpa.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;


    public PostServiceImpl(PostRepository postRepository, BoardRepository boardRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
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

    @Transactional
    public Long savePost(Post post, long id) {
        BoardEntity boardEntity = boardRepository.getReferenceById(id);//findbyId 말고 jparepository getone
        PostEntity postEntity = post.toEntity(boardEntity);

        postRepository.save(postEntity);
        return boardRepository.save(boardEntity).getId();
    }

    @Transactional
    public void deletePost(Long id) {
      postRepository.deleteById(id);
    }

    @Transactional
    public void updatePost(Post post) {
        PostEntity p = postRepository.getReferenceById(post.getId());
        p.update(post.getTitle(), post.getContents());
        postRepository.save(p);
    }

    @Transactional
    public Page<PostEntity> pageList(Pageable pageable)
    {
        return postRepository.findAll(pageable);
    }

}