package com.ch.zn.wzl.demo.reids.operation.proxy;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ch.zn.wzl.demo.reids.client.RedisClient;
import com.ch.zn.wzl.demo.reids.operation.annotations.RedisOperation;

import redis.clients.jedis.JedisCommands;

@Component
@Aspect
public class RedisOperationProxy {

	@Autowired
	private RedisClient redisClient;

	public RedisClient getRedisClient() {
		return redisClient;
	}

	public void setRedisClient(RedisClient redisClient) {
		this.redisClient = redisClient;
	}

	@Around("@annotation(com.ch.zn.wzl.demo.reids.operation.annotations.RedisOperation)")
	public Object proxyMethodCache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature joinPointObject = (MethodSignature) proceedingJoinPoint.getSignature();
		Method method = joinPointObject.getMethod();
		RedisOperation redisOperation = method.getAnnotation(RedisOperation.class);
		// 解析参数位置

		int redisIndex = redisOperation.ShardedJedisIndex();
		int dbIndexIndex = redisOperation.dbIndexIndex();
		Object[] args = proceedingJoinPoint.getArgs();
		Object result = null;
		int dbIndex = (int) args[dbIndexIndex];
		JedisCommands jedisCommands = redisClient.getConnection(dbIndex);
		try {
			// 更改参数执行
			args[redisIndex] = jedisCommands;
			result = proceedingJoinPoint.proceed(args);
		} finally {
			redisClient.closeConnection(dbIndex, jedisCommands);
		}
		return result;
	}

}
