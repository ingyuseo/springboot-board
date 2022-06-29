package com.example.swcoaching.board.jpa;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 게시물
 */
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "post")
@Entity
public class PostEntity {
  /**
   * 게시글 id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 게시글 이름
   */
  @Column(length = 1000)
  private String title;

  /**
   * 게시글 내용
   */
  @Column(columnDefinition = "text")
  private String contents;

  /**
   * 글쓴 날짜
   */
  @CreatedDate
  private LocalDateTime createDate;

  /**
   * 마지막 수정 날짜
   */
  @LastModifiedDate
  private LocalDateTime lastUpdatedDate;

  /**
   * 글쓴이 정보
   */
  @Column(length = 50)
  private String username;

  /**
   * 조회수
   * */
  @Column
  private Long hits;

  /**
   * 댓글 (나중에 구현..)
   */


  @ManyToOne
  @JoinColumn(name = "boardId")
  private BoardEntity board;


}