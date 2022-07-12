package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.BoardEntity;
import com.example.swcoaching.board.jpa.BoardRepository;
import com.example.swcoaching.board.jpa.PostEntity;
import com.example.swcoaching.board.jpa.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

  private final BoardRepository boardRepository;

  public BoardServiceImpl(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public Board findById(long id) {
    return boardRepository.findById(id)
            .map(Board::of)
            .orElseThrow(() -> new BoardNotFoundException(id));
  }
  @Transactional
  public List<Board> findAllBoards(){
    List<Board> Boards = new ArrayList<>();

    for(BoardEntity e : boardRepository.findAll())
    {
      Boards.add(Board.of(e));
    }

    return Boards;
  }

  @Transactional
  public Long saveBoard(Board board) {
    List<PostEntity> list = Collections.emptyList();
    return boardRepository.save(board.toEntity(list)).getId();
  }


}