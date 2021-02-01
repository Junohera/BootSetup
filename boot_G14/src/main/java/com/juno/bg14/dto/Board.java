package com.juno.bg14.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Board{
    private int num;
    private String userid;
    private String pass;
    private String email;
    private String title;
    private String content;
    private int readcount;
    private Timestamp writedate;
    private int replycnt;
    private String image;
}
