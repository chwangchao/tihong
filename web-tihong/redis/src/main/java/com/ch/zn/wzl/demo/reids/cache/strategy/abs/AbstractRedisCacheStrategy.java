package com.ch.zn.wzl.demo.reids.cache.strategy.abs;

import com.ch.zn.wzl.demo.reids.cache.annotations.MethodsMapCache;
import com.ch.zn.wzl.demo.reids.cache.serialization.Serialization;
import com.ch.zn.wzl.demo.reids.cache.strategy.CacheStrategy;
import com.ch.zn.wzl.demo.reids.operation.helper.ProxyRedisCommand;

public abstract class AbstractRedisCacheStrategy implements CacheStrategy {

	protected int defaultCacheTime;

	protected int defaultCacheDb;

	protected Serialization keySerialization;

	protected Serialization valSerialization;

	protected ProxyRedisCommand proxyRedisCommand;

	public Serialization getKeySerialization() {
		return keySerialization;
	}

	public void setKeySerialization(Serialization keySerialization) {
		this.keySerialization = keySerialization;
	}

	public Serialization getValSerialization() {
		return valSerialization;
	}

	public void setValSerialization(Serialization valSerialization) {
		this.valSerialization = valSerialization;
	}

	public int getDefaultCacheTime() {
		return defaultCacheTime;
	}

	public void setDefaultCacheTime(int defaultCacheTime) {
		this.defaultCacheTime = defaultCacheTime;
	}

	public int getDefaultCacheDb() {
		return defaultCacheDb;
	}

	public void setDefaultCacheDb(int defaultCacheDb) {
		this.defaultCacheDb = defaultCacheDb;
	}

	public int getCacheDb(MethodsMapCache methodsMapCache) {
		int i = methodsMapCache.cacheDb();
		return i == 0 ? defaultCacheDb : i;
	}

	public int getCacheTime(MethodsMapCache methodsMapCache) {
		int i = methodsMapCache.cacheTime();
		return i == 0 ? defaultCacheTime : i;
	}

	public String getkey(MethodsMapCache methodsMapCache) {
		String string = methodsMapCache.key();
		if ("".equals(string)) {
			return null;
		} else {
			return string;
		}
	}

	public ProxyRedisCommand getProxyRedisCommand() {
		return proxyRedisCommand;
	}

	public void setProxyRedisCommand(ProxyRedisCommand proxyRedisCommand) {
		this.proxyRedisCommand = proxyRedisCommand;
	}

	public String get(int db, String key, String optoins) {
		return proxyRedisCommand.get(db, key);
	}

	public String hget(int db, String key, String field, String options) {
		return proxyRedisCommand.hget(db, key, field);
	}

	public void set(int db, String key, String val, int time, String options) {
		proxyRedisCommand.set(db, key, val);
		proxyRedisCommand.expire(db, key, time);
	}

	public void hset(int db, String key, String field, String val, int time, String options) {
		proxyRedisCommand.hset(db, key, field, val);
		proxyRedisCommand.expire(db, key, time);
	}

}
