package com.i.me.board.controller;

import java.util.List;

import com.i.me.board.boardService.BoardService;
import com.i.me.board.boardService.PostsService;
import com.i.me.board.dto.BoardDto;
import com.i.me.domain.auth.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private HttpSession httpSession;

    //처음 게시판 index
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView openBoardList() throws Exception {
        ModelAndView mv = new ModelAndView("/index"); //templates 폴더 아래있는 /~~.mustache을 의미
        List<BoardDto> dto = boardService.selectBoardList(); //게시글 목록을 조회하기 위해 ServiceImpl 클래스의 selectBoardList 메서드 호출
        mv.addObject("list", dto);

        //springSecurity
        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //로그인 성공 시 세션에 SessionUser를 저장.
        if (user != null) {
            mv.addObject("userName", user.getName());
        }
        return mv;
    }
    
    //글쓰는 화면
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String posts() throws Exception {
        return "posts-create";
    }

    //게시글 하나 상세내역 조회
    @GetMapping("/posts/update/{idx}")
    public ModelAndView postsUpdate(@PathVariable int idx,Model model) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("posts-update");
        mav.addObject("post",boardService.findByIdx(idx));

        return mav;
    }



}