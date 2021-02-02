package com.juno.bm01.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class Member {
	@NotEmpty(message="id is empty")
    private String id;
	@NotEmpty(message="pwd is empty")
    private String pwd;
	@NotEmpty(message="name is empty")
    private String name;
	@NotEmpty(message="email is empty")
    private String email;
    private String zip_num;
    private String address;
    private String phone;
    private String useyn;
    private Timestamp indate;
}
