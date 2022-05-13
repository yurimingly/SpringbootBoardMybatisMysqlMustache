package com.i.me.board.boardService;

import com.i.me.board.dto.BoardDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface PostsService {

    //게시글 작성 C
    @Transactional
    public void insertBoard(BoardDto dto) throws Exception;

    //게시글 수정하기 U
    @Transactional
    public void updateBoard(@RequestBody BoardDto dto) throws Exception;

    @Transactional
    public void deleteBoard(int idx) throws Exception;
}
