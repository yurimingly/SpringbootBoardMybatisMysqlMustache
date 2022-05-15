package com.i.me.board.boardImpl;

import com.i.me.board.boardService.PostsService;
import com.i.me.board.dto.BoardDto;
import com.i.me.board.mapper.BoardMapper;
import com.sun.media.jfxmedia.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PostsServiceImpl implements PostsService {

    @Autowired //Mapper와 연결
    private BoardMapper BoardMapper;

    //게시글 쓰기
    @Override
    public void insertBoard(BoardDto dto) throws Exception {
        BoardMapper.insertBoard(dto);
    }

    @Override
    public void updateBoard(@RequestBody BoardDto dto) throws Exception {
        System.out.println("IMPL - " + "BoardDto"+ dto);
        BoardMapper.updateBoard(dto);
    }

    @Override
    public void deleteBoard(int idx) throws Exception {
        BoardMapper.deleteBoard(idx);
    }
}
