package com.example.swcoaching.controller;

import com.example.swcoaching.board.Board;
import com.example.swcoaching.board.BoardService;
import com.example.swcoaching.board.Post;
import com.example.swcoaching.board.jpa.BoardEntity;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping
public class BoardController {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  private final BoardService boardService;

  @GetMapping("/board/{boardId}")
  public Board getBoard(@PathVariable long boardId) {
    Board board = boardService.findById(boardId);
    logger.info("Board: {}", board);
    return board;
  }

  @GetMapping("/board/openBoardWrite")		//게시글 작성 화면 호출
  public String openPostWrite() throws Exception{
    return "test";
  }

  /*@PostMapping("/board/insertBoard.do")		//작성된 게시글 등록 기능 메소드, html의 form 태그 action에서 입력한 주소
  public String insertBoard(@RequestBody Board board) throws Exception{
    boardService.saveBoard(board);
    return "redirect:/board/openBoardList.do";	//게시글 리스트로 이동
  }
  */

  /*
  @PostMapping("/board")
  public BoardEntity saveBoard(@RequestBody BoardEntity boardEntity){
    return boardService.saveBoard(boardEntity);
  }
  */
}