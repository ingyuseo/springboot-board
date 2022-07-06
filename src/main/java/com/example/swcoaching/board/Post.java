package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.BoardEntity;
import com.example.swcoaching.board.jpa.PostEntity;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;

/**
 * 게시물
 */
@ToString
@Getter
public class Post {
  private final Long id;

  private final String title;

  private final String contents;

  private final String username;

  private final Long hits;


  public Post(Long id, String title, String contents, String username) {
    this.id = id;
    this.title = title;
    this.contents = contents;
    this.username = username;
    this.hits = 0L;
  }

  public static Post of(PostEntity postEntity) {
    return new Post(postEntity.getId(), postEntity.getTitle(), postEntity.getContents(), postEntity.getUsername());
  }

  public PostEntity toEntity(long board_id){
    return PostEntity.builder()
            .title(title)
            .contents(contents)
            .username(username)
            .board_id(board_id)
            .build();
  }

}