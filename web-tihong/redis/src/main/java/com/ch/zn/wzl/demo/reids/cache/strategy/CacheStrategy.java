package com.ch.zn.wzl.demo.reids.cache.strategy;

import java.lang.reflect.Method;

import com.ch.zn.wzl.demo.reids.cache.annotations.MethodsMapCache;

/**
 *缓存策略 主管缓存判断
 */
public interface CacheStrategy {

	String getStrategy();

	void cacheVal(MethodsMapCache mapCaches, Method method, Object[] args, Object val);

	Object getCache(MethodsMapCache methodsMapCache, Object[] args, Method method);

}
