package com.i.me.board.boardService;

import java.util.List;

import com.i.me.board.dto.BoardDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface BoardService {
    
    //index 화면
    @Transactional
    public List<BoardDto> selectBoardList() throws Exception;

    //게시글 보기 R
    @Transactional
    public BoardDto findByIdx(int idx) throws Exception;

}
