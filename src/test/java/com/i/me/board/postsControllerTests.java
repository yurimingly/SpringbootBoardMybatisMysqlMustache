package com.i.me.board;

import com.i.me.board.dto.BoardDto;
import com.i.me.board.mapper.BoardMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
public class postsControllerTests {

    @Autowired
    BoardMapper boardMapper;

    @Test
    public void InsertAndFindbyidx() throws Exception {
        BoardDto testDto = new BoardDto(1,"첫","내","author1","2022-05-11 23:54:11");
        boardMapper.insertBoard(testDto);
        BoardDto test2Dto = boardMapper.findByIdx(testDto.getIdx());
        assertThat(testDto.getTitle().equals(test2Dto.getTitle()));
    }

}