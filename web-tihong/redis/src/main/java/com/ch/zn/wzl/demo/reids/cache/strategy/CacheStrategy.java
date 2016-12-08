package com.ch.zn.wzl.demo.reids.cache.strategy;

import java.lang.reflect.Method;

import com.ch.zn.wzl.demo.reids.cache.annotations.MethodsMapCache;

public interface CacheStrategy {

	String getStrategy();

	void cacheVal(MethodsMapCache mapCaches, Object[] args, Object val);

	Object getCache(MethodsMapCache methodsMapCache, Object[] args, Method method);

}
