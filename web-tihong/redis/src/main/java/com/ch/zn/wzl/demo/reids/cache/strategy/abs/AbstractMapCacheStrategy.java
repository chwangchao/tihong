package com.ch.zn.wzl.demo.reids.cache.strategy.abs;

import java.lang.reflect.Method;

import com.ch.zn.wzl.demo.reids.cache.annotations.MethodsMapCache;
import com.ch.zn.wzl.demo.reids.cache.info.ICacheProxyInfo;
import com.ch.zn.wzl.demo.reids.cache.info.impl.SimpleCacheProxyInfo;

public abstract class AbstractMapCacheStrategy extends AbstractRedisCacheStrategy {

	public ICacheProxyInfo initCacheProxyInfo(MethodsMapCache methodsMapCache, Object[] args, Method method) {
		ICacheProxyInfo iCacheProxyInfo = new SimpleCacheProxyInfo(methodsMapCache.targetArgs(), method, args,
				methodsMapCache.optoins());
		return iCacheProxyInfo;
	}

	public Object toValObject(ICacheProxyInfo iCacheProxyInfo, String serializeString, Class<?> cls) {
		return iCacheProxyInfo.toValObject(valSerialization, serializeString, cls);
	}

	@Override
	public Object getCache(MethodsMapCache methodsMapCache, Object[] args, Method method) {
		ICacheProxyInfo iCacheProxyInfo = initCacheProxyInfo(methodsMapCache, args, method);
		String rootKey = getkey(methodsMapCache);
		String serializeString;

		String key = iCacheProxyInfo.toKeyString(keySerialization);
		int cacheDb = getCacheDb(methodsMapCache);

		if (rootKey == null) {
			serializeString = get(cacheDb, key, methodsMapCache.optoins());
		} else {
			serializeString = hget(cacheDb, rootKey, key, methodsMapCache.optoins());
		}
		Object object = toValObject(iCacheProxyInfo, serializeString, method.getClass());
		return object;
	}

	@Override
	public void cacheVal(MethodsMapCache methodsMapCache, Method method, Object[] args, Object val) {
		ICacheProxyInfo iCacheProxyInfo = initCacheProxyInfo(methodsMapCache, args, method);
		String rootKey = getkey(methodsMapCache);

		String keyString = iCacheProxyInfo.toKeyString(keySerialization);
		int cacheDb = getCacheDb(methodsMapCache);
		String valString = iCacheProxyInfo.toValString(valSerialization, val);
		int cacheTime = getCacheTime(methodsMapCache);

		if (rootKey == null) {
			set(cacheDb, keyString, valString, cacheTime, methodsMapCache.optoins());
		} else {
			hset(cacheDb, rootKey, keyString, valString, cacheTime, methodsMapCache.optoins());
		}
	}

}
