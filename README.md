# SpringbootBoardMybatisMysqlMustache
안녕하세요~ 이유있는 개발자 호루루입니다.
이번 커밋은 SpringSecurity + Springboot + Mybatis + Mysql + Mustache 를 이용하여 만들어 본 게시판입니다~
회원가입 및 로그인은 google Cloud Platform의 로그인 API를 이용하여 만들어 보았습니다.

SPRINGBOOT 2.6.7
GRADLE 7.4.1
JAVA 8
MySQL Server 8.0
-----------------------------------------------------------------------------------------
/*MYSQL QUERY 참고*/
create database me;
use me;

drop table board;
create table board(
idx int(20) auto_increment primary key,
title varchar(100),
content varchar(500),
author varchar(50),
modifiedDate varchar(20)
);
select * from board;
/*
INSERT INTO board (idx, title, content, author, modifiedDate) values(1,"나는누구인가","안녕하세요. 저는 horuru라고 하는 개발자입니다.","horuru", now());
INSERT INTO board (idx, title, content, author, modifiedDate) values(0,"q","w", "e",now());

update board
set title = "나는누구인가"
where code = 1;
commit;
*/

drop table user;
create table user(
name varchar(100),
email varchar(100),
role varchar(20)
);
select * from user;
/*
INSERT INTO user(name,email,role) VALUES("테스트이름","yuyu9895@gmail.com","GUEST");
SELECT * FROM user WHERE email = "yuyu9895@gmail.com"
*/
