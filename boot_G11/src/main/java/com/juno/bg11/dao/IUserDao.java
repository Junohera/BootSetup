package com.juno.bg11.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.juno.bg11.dto.User;

@Mapper
public interface IUserDao {
	List<User> list();
}
