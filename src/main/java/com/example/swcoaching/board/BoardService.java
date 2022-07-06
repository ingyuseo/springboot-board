package com.example.swcoaching.board;

import java.util.List;

public interface BoardService {
  Board findById(long id);

  List<Board> findAllBoards();
  Long saveBoard(Board board);
}