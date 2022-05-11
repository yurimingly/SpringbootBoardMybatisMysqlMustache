package com.i.me.board.boardService;

import java.util.List;

import com.i.me.board.dto.BoardDto;

public interface BoardService {
    
    //index 화면
    public List<BoardDto> selectBoardList() throws Exception;

    //게시글 보기 R
    public BoardDto findById(int idx) throws Exception;

}
