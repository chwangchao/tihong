package com.ch.zn.wzl.demo.reids.cache.strategy.abs;

import com.ch.zn.wzl.demo.reids.cache.serialization.Serialization;
import com.ch.zn.wzl.demo.reids.cache.strategy.CacheStrategy;
import com.ch.zn.wzl.demo.reids.operation.helper.ProxyRedisCommand;

/**
 * 
 * reids 缓存策略
 */
public abstract class AbstractRedisCacheStrategy implements CacheStrategy {

	/**
	 *策略的 默认缓存时间
	 */
	protected int defaultCacheTime;

	/**
	 * 策略的 默认缓存库
	 */
	protected int defaultCacheDb;

	/**
	 * key 序列化方式
	 */
	protected Serialization keySerialization;

	/**
	 * val 序列化方式
	 */
	protected Serialization valSerialization;

	/**
	 * redis 操作
	 */
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

	public int getCacheDb(int i ) {
		return i == 0 ? defaultCacheDb : i;
	}

	public int getCacheTime(int i ) {
		return i == 0 ? defaultCacheTime : i;
	}

	public String getkey(String string) {
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
		if (time!=-1) {
			proxyRedisCommand.expire(db, key, time);
		}
	}

	public void hset(int db, String key, String field, String val, int time, String options) {
		proxyRedisCommand.hset(db, key, field, val);
		if (time!=-1) {
			proxyRedisCommand.expire(db, key, time);
		}
	}

}
