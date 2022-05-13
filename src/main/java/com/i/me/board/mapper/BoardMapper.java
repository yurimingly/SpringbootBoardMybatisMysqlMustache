package com.i.me.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.i.me.board.dto.BoardDto;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardMapper {
    //맨 처음 index페이지
    List<BoardDto> selectBoardList() throws Exception; //여기서 지정한 메서드의 이름은 쿼리의 이름과 동일해야 함 (selectBoardList)

    //글쓰기
    void insertBoard(BoardDto dto) throws Exception;

    //게시글 보기
    BoardDto findByIdx(int idx) throws Exception;

    //게시글 수정
    void updateBoard(BoardDto dto) throws Exception;
    
    //게시글 삭제
    void deleteBoard(int idx) throws Exception;
}