package com.example.swcoaching.board.jpa;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 게시물
 */
@Getter
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
   * 게시판 이름
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

  /**
   * 마지막 수정 날짜
   */

  /**
   * 글쓴이 정보
   */

  /**
   * 조회수
   * */

  /**
   * 댓글
   */

  @ManyToOne
  @JoinColumn(name = "boardId")
  private BoardEntity board;


}