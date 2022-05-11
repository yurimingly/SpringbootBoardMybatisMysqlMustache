package com.i.me.board.boardImpl;

import java.util.List;

import com.i.me.board.boardService.BoardService;
import com.i.me.board.dto.BoardDto;
import com.i.me.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service //서비스임을 선언
public class BoardServiceImpl implements BoardService {

    @Autowired //Mapper와 연결
    private BoardMapper BoardMapper;

    //게시판 보기
    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        // TODO Auto-generated method stub
        return BoardMapper.selectBoardList();
    }

    //게시물 보기
    @Override
    public BoardDto findById(int idx) throws Exception {
        return BoardMapper.findById(idx);
    }


}