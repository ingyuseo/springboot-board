package com.example.swcoaching.controller;

import com.example.swcoaching.board.Board;
import com.example.swcoaching.board.BoardService;
import com.example.swcoaching.board.Post;
import com.example.swcoaching.board.PostService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static com.example.swcoaching.board.PostService.*;


@AllArgsConstructor
@Controller
@RequestMapping
public class ViewController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final BoardService boardService;
    private final PostService postService;

    @GetMapping("/board/BoardWrite")
    public String openBoardWrite() throws Exception{
        return "boardWrite";
    }

    @GetMapping("/board/postWrite/{id}")
    public ModelAndView openPostWrite(@PathVariable long id) throws Exception{
        ModelAndView mav = new ModelAndView("postWrite");
        mav.addObject("board_id", id);

        return mav;
    }

    @GetMapping("/board/list")
    public ModelAndView boardlist() throws Exception{
        ModelAndView mav = new ModelAndView("boardlist");
        List<Board> Boards = boardService.findAllBoards();
        mav.addObject("boards",Boards);
        return mav;
    }

    @PostMapping("/board/insert-board")
    public String insertBoard(@ModelAttribute Board board) throws Exception{
        logger.info("called!");
        logger.info("board : {} {} {} {}" , board.getId(),board.getTitle() ,board.getRemark() ,board.getPosts());
        boardService.saveBoard(board);
        return "test";
    }

    @PostMapping("/board/insert")
    public String insertPost(@RequestParam("board_id") Long id, @ModelAttribute Post post, RedirectAttributes re) throws Exception{
        postService.savePost(post, id);
        re.addAttribute("id", id);
        return "redirect:/board/list/{id}";
    }

    @DeleteMapping("/delete/")
    public String deletePost(@ModelAttribute Post post) throws Exception{
        postService.deletePost(post);
        return "test";
    }


    @GetMapping("/board/list/{id}")
    public ModelAndView postlist(@PathVariable Long id) throws Exception{
        ModelAndView mav = new ModelAndView("postlist");

        Board board = boardService.findById(id);

        List<Post> Posts = postService.PostInBoard(id);
        mav.addObject("Posts", Posts);
        mav.addObject("Board",board);
        return mav;
    }

}