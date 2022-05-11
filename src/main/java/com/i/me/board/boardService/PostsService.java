package com.i.me.board.boardService;

import com.i.me.board.dto.BoardDto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface PostsService {

    //게시글 작성 C
    public void insertBoard(BoardDto dto) throws Exception;

    //게시글 수정하기 U
    public void updateBoard(@RequestBody BoardDto dto) throws Exception;


    public void deleteBoard(int idx) throws Exception;
}
