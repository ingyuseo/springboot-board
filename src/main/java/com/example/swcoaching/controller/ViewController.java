package com.example.swcoaching.controller;

import com.example.swcoaching.board.Board;
import com.example.swcoaching.board.BoardService;
import com.example.swcoaching.board.Post;
import com.example.swcoaching.board.PostService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


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
        boardService.saveBoard(board);
        return "pagingtest";
    }

    @PostMapping("/board/insert")
    public String insertPost(@RequestParam("board_id") Long id, @ModelAttribute Post post, RedirectAttributes re) throws Exception{
        postService.savePost(post, id);
        re.addAttribute("id", id);
        return "redirect:/board/list/{id}";
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

    @GetMapping("/view/")
    public ModelAndView viewPost(@RequestParam(value = "bid") Long bid, @RequestParam(value = "pid") Long pid) throws Exception{
        ModelAndView mav = new ModelAndView("viewpost");
        Post post = postService.findById(pid);
        mav.addObject("Post", post);
        mav.addObject("bid",bid);
        return mav;
    }

    @GetMapping("/delete/")
    public String deletePost(@RequestParam("bid") Long bid, @RequestParam("pid")  Long pid, RedirectAttributes re) throws Exception{
        postService.deletePost(pid);
        re.addAttribute("bid", bid);
        return "redirect:/board/list/{bid}";
    }

    @PostMapping("/update")
    public String updatePost(@RequestParam("bid") Long id, @ModelAttribute Post post, RedirectAttributes re) throws Exception{
        postService.updatePost(post);
        re.addAttribute("bid", id);
        re.addAttribute("pid", post.getId());
        return "redirect:/view/";
    }

    @PostMapping("/updateWrite")
    public ModelAndView updateForm(@RequestParam("bid") Long bid, @RequestParam("pid") Long pid) throws Exception{
        ModelAndView mav = new ModelAndView("updateWrite");

        Post post = postService.findById(pid);
        mav.addObject("Post", post);
        mav.addObject("bid", bid);
        return mav;
    }


    @GetMapping("/")
    public ModelAndView index(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("posts", postService.pageList(pageable));
        return mav;
    }


}