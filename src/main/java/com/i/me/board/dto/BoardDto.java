package com.i.me.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDto {
    private int idx;
    private String title;
    private String content;
    private String author;
    private String modifiedDate;

}
