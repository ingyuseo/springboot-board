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

    @GetMapping("/board/openBoardWrite")		//�Խñ� �ۼ� ȭ�� ȣ��
    public String openPostWrite() throws Exception{
        return "boardWrite";
    }

    @PostMapping("/board/insertBoard")		//�ۼ��� �Խñ� ��� ��� �޼ҵ�, html�� form �±� action���� �Է��� �ּ�
    public String insertBoard(@ModelAttribute Board board) throws Exception{
        logger.info("called!");
        logger.info("board : {} {} {} {}" , board.getId(),board.getTitle() ,board.getRemark() ,board.getPosts());
        boardService.saveBoard(board);
        return "test";	//���� ȭ������ �̵�
    }


  /*
  @PostMapping("/board")
  public BoardEntity saveBoard(@RequestBody BoardEntity boardEntity){
    return boardService.saveBoard(boardEntity);
  }
  */
}