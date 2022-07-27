package com.example.redisdemo.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.support.collections.RedisProperties;

import javax.annotation.Resource;

@Configuration
public class RedisConfig {
	@Resource
	private RedisTemplate redisTemplate;

	@Bean
	public RedisTemplate redisTemplateInit(){
		//序列化key的实例化对象
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		//序列化value的实例化对象
		redisTemplate.setValueSerializer(new GenericFastJsonRedisSerializer());
		return redisTemplate;
	}
}
