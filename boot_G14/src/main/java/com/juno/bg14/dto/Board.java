package com.juno.bg14.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class Board {
    private int num;
    @NotEmpty(message="userid is empty")
    private String userid;
    @NotEmpty(message="pass is empty. 게시글 수정 삭제시 필요합니다.")
    private String pass;
    @NotEmpty(message="email is empty")
    private String email;
    @NotEmpty(message="title is empty")
    private String title;
    @NotEmpty(message="content is empty")
    private String content;
    private int readcount;
    private Timestamp writedate;
    private int replycnt;
    private String image;
}
