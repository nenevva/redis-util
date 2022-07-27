package com.example.redisdemo.mapper;

import com.example.redisdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

	User getUserById(String loginid);
}
