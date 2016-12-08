package com.ch.zn.wzl.demo.reids.cache.strategy;

public interface CacheStrategy {

	boolean hasCache(String[] key);

	<T> T getCache(String[] key, String options);

	void cacheVal(int seconds, String[] key, Object val);
}
