package com.ch.zn.wzl.demo.reids.client.sharded;

import java.util.Map;

import com.ch.zn.wzl.demo.reids.client.RedisClient;

import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class ShardedRedisClient implements RedisClient {

	public Map<Integer, ShardedJedisPool> pools;

	@Override
	public JedisCommands getConnection(int dbIndex) {
		return pools.get(dbIndex).getResource();
	}

	@Override
	public void closeConnection(int dbIndex, JedisCommands jedisCommands) {
		pools.get(dbIndex).returnResourceObject((ShardedJedis) jedisCommands);
	}

}
