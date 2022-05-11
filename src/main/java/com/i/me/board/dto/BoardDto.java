package com.i.me.board.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class BoardDto {
    private int idx;
    private String title;
    private String content;
    private String author;
    private String modifiedDate;
}
