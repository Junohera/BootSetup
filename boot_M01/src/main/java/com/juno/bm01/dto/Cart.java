package com.juno.bm01.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Cart {
    private Integer cseq;
    private String id;
    private Integer pseq;
    private String mname;
    private String pname;
    private Integer quantity;
    private Integer price2;
    private Timestamp indate;
}
