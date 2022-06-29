package com.example.swcoaching.controller;

import com.example.swcoaching.board.Board;
import com.example.swcoaching.board.BoardService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@Controller
@RequestMapping
public class viewController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final BoardService boardService;

    @GetMapping("/board/openBoardWrite")		//게시글 작성 화면 호출
    public String openPostWrite() throws Exception{
        return "boardWrite";
    }

    @PostMapping("/board/insertBoard")		//작성된 게시글 등록 기능 메소드, html의 form 태그 action에서 입력한 주소
    public String insertBoard(@ModelAttribute Board board) throws Exception{
        logger.info("called!");
        logger.info("board : {} {} {} {}" , board.getId(),board.getTitle() ,board.getRemark() ,board.getPosts());
        boardService.saveBoard(board);
        return "test";	//메인 화면으로 이동
    }


  /*
  @PostMapping("/board")
  public BoardEntity saveBoard(@RequestBody BoardEntity boardEntity){
    return boardService.saveBoard(boardEntity);
  }
  */
}