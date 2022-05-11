package com.i.me.board.controller;

import com.i.me.board.boardService.BoardService;
import com.i.me.board.boardService.PostsService;
import com.i.me.board.dto.BoardDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostsApiController {
    
    @Autowired
    private PostsService postsService;
    
    //글쓰기
    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String postsCreate(@RequestBody BoardDto dto) throws Exception {
        postsService.insertBoard(dto);
        //System.out.println("data " + dto + ".");
        return "posts-create";
    }
    //업데이트
    @PatchMapping("/posts/update/{idx}")
    public void update(@PathVariable("idx") int idx, @RequestBody BoardDto dto) throws Exception {
        System.out.println("Controller - idx : " +idx + "BoardDto"+ dto);
        postsService.updateBoard(dto);
    }
    
    //지우기
    @DeleteMapping("/posts/delete/{idx}")
    public int delete(@PathVariable int idx) throws Exception {
        postsService.deleteBoard(idx);
        return idx;
    }

}
