package com.ch.zn.wzl.demo.reids.client.sharded;

import java.util.Map;

import com.ch.zn.wzl.demo.reids.client.RedisClient;

import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class ShardedRedisClient implements RedisClient {

	protected Map<Integer, ShardedJedisPool> poolsMap;

	public Map<Integer, ShardedJedisPool> getPoolsMap() {
		return poolsMap;
	}

	public void setPoolsMap(Map<Integer, ShardedJedisPool> poolsMap) {
		this.poolsMap = poolsMap;
	}

	@Override
	public JedisCommands getConnection(int dbIndex) {
		return poolsMap.get(dbIndex).getResource();
	}

	@Override
	public void closeConnection(int dbIndex, JedisCommands jedisCommands) {
		poolsMap.get(dbIndex).returnResourceObject((ShardedJedis) jedisCommands);
	}

}
