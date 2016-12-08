package com.ch.zn.wzl.demo.reids.cache.strategy.impl;

import com.ch.zn.wzl.demo.reids.cache.strategy.AbstractMapCacheStrategy;

public class DefaultAbstractMapCacheStrategy extends AbstractMapCacheStrategy {

	public static final String DefaultAbstractMapCacheStrategy = "DefaultAbstractMapCacheStrategy";

	@Override
	public String getStrategy() {
		return DefaultAbstractMapCacheStrategy;
	}

	@Override
	public String get(int db, String key, String optoins) {
		return proxyRedisCommand.get(db, key);
	}

	@Override
	public String hget(int db, String key, String field, String options) {
		return proxyRedisCommand.hget(db, key, field);
	}

	@Override
	public void set(int db, String key, String val, int time, String options) {
		proxyRedisCommand.set(db, key, val);
		proxyRedisCommand.expire(db, key, time);
	}

	@Override
	public void hset(int db, String key, String field, String val, int time, String options) {
		proxyRedisCommand.hset(db, key, field, val);
		proxyRedisCommand.expire(db, key, time);
	}

}
