package com.example.swcoaching.board.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name = "board")
@Entity
@NoArgsConstructor
public class BoardEntity {
  /**
   * 게시판 id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
//primitive 는 null일 수 없다. 래퍼클래스
  /**
   * 게시판 제목
   */
  @Column(length = 1000)
  private String title;

  /**
   * 게시판 설명
   */
  @Column(columnDefinition = "text")
  private String remark;

  /**
   * 게시물
   */
  @OneToMany(mappedBy = "board")
  public List<PostEntity> posts = new ArrayList<>();

  @Builder
  public BoardEntity(String title, String remark, List<PostEntity> posts) {
    this.title = title;
    this.remark = remark;
    this.posts = posts;
  }

}