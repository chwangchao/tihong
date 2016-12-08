package com.ch.zn.wzl.demo.reids.client;

import redis.clients.jedis.JedisCommands;

public interface RedisClient {

	JedisCommands getConnection(int dbIndex);

	void closeConnection(int dbIndex, JedisCommands jedisCommands);
}
