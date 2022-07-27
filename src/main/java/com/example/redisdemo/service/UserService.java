package com.example.redisdemo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.redisdemo.entity.User;
import com.example.redisdemo.mapper.UserMapper;
import com.example.redisdemo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

	@Resource
	private UserMapper userMapper;

	@Autowired
	private RedisUtil redisUtil;

	public String getUserService(String s) {

		String ret = (String) redisUtil.get(s);

		if (ret == null) {
			User user = userMapper.getUserById(s);
			redisUtil.set(s, user.getLastname());
			return user.getLastname();
		} else {
			return ret;
		}
	}
}