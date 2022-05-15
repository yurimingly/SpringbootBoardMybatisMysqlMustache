package com.i.me.domain.auth;

import com.i.me.domain.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper {
    //로그인 & 회원가입
    User findByEmail(String email);
    void save(User user);
}