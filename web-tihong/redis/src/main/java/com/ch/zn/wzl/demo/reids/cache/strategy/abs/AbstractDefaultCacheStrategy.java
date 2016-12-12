package com.ch.zn.wzl.demo.reids.cache.strategy.abs;

import java.lang.reflect.Method;

import com.ch.zn.wzl.demo.reids.cache.annotations.MethodsMapCache;
import com.ch.zn.wzl.demo.reids.cache.info.ICacheProxyInfo;
import com.ch.zn.wzl.demo.reids.cache.info.impl.SimpleCacheProxyInfo;

public abstract class AbstractDefaultCacheStrategy extends AbstractRedisCacheStrategy {

	/**
	 * 初始化缓存信息
	 * @param methodsMapCache
	 * @param args
	 * @param method
	 * @return
	 */
	public ICacheProxyInfo initCacheProxyInfo(MethodsMapCache methodsMapCache, Object[] args, Method method) {
		ICacheProxyInfo iCacheProxyInfo = new SimpleCacheProxyInfo(methodsMapCache.targetArgs(), method, args,
				methodsMapCache.optoins());
		return iCacheProxyInfo;
	}

	/**
	 * 反序列化值
	 * @param iCacheProxyInfo 缓存信息
	 * @param serializeString 缓存策略
	 * @param cls
	 * @return
	 */
	public Object toValObject(ICacheProxyInfo iCacheProxyInfo, String serializeString, Class<?> cls) {
		return iCacheProxyInfo.toValObject(valSerialization, serializeString, cls);
	}

	@Override
	public Object getCache(MethodsMapCache methodsMapCache, Object[] args, Method method) {
		//生成缓存配置信息
		ICacheProxyInfo iCacheProxyInfo = initCacheProxyInfo(methodsMapCache, args, method);
		//读取注解配置的缓存根
		String rootKey = getkey(methodsMapCache.key());
		String serializeString;
		// 健
		String key = iCacheProxyInfo.toKeyString(keySerialization);
		// 缓存库
		int cacheDb = getCacheDb(methodsMapCache.cacheDb());
		// 如果没有缓存根,以一级目录进行缓存,如果有缓存根,用二级目录进行缓存
		if (rootKey == null) {
			serializeString = get(cacheDb, key, methodsMapCache.optoins());
		} else {
			serializeString = hget(cacheDb, rootKey, key, methodsMapCache.optoins());
		}
		//读取的缓存进行反序列化
		Object object = toValObject(iCacheProxyInfo, serializeString, method.getReturnType());
		return object;
	}

	@Override
	public void cacheVal(MethodsMapCache methodsMapCache, Method method, Object[] args, Object val) {
		//缓存配置
		ICacheProxyInfo iCacheProxyInfo = initCacheProxyInfo(methodsMapCache, args, method);
		String rootKey = getkey(methodsMapCache.key());

		String keyString = iCacheProxyInfo.toKeyString(keySerialization);
		int cacheDb = getCacheDb(methodsMapCache.cacheDb());
		String valString = iCacheProxyInfo.toValString(valSerialization, val);
		int cacheTime = getCacheTime(methodsMapCache.cacheTime());

		if (rootKey == null) {
			set(cacheDb, keyString, valString, cacheTime, methodsMapCache.optoins());
		} else {
			hset(cacheDb, rootKey, keyString, valString, cacheTime, methodsMapCache.optoins());
		}
	}

}
