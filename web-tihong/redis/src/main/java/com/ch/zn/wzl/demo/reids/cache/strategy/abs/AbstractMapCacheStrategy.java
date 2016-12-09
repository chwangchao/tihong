package com.ch.zn.wzl.demo.reids.cache.strategy.abs;

import java.lang.reflect.Method;

import com.ch.zn.wzl.demo.reids.cache.annotations.MethodsMapCache;

public abstract class AbstractMapCacheStrategy extends AbstractCacheStrategy {

	@Override
	public Object getCache(MethodsMapCache methodsMapCache, Object[] args, Method method) {
		Object[] objects = getTargetArgs(methodsMapCache, method, args);
		String rootKey = getkey(methodsMapCache);
		String string;
		if (rootKey == null) {
			string = get(getCacheDb(methodsMapCache), keySerialization.toString(objects), methodsMapCache.optoins());
		} else {
			string = hget(getCacheDb(methodsMapCache), rootKey, keySerialization.toString(objects),
					methodsMapCache.optoins());
		}
		return valSerialization.toObject(string, method.getReturnType());
	}

	@Override
	public void cacheVal(MethodsMapCache methodsMapCache, Method method, Object[] args, Object val) {
		Object[] objects = getTargetArgs(methodsMapCache, method, args);
		String rootKey = getkey(methodsMapCache);
		if (rootKey == null) {
			set(getCacheDb(methodsMapCache), keySerialization.toString(objects), valSerialization.toString(val),
					getCacheTime(methodsMapCache), methodsMapCache.optoins());
		} else {
			hset(getCacheDb(methodsMapCache), rootKey, keySerialization.toString(objects),
					valSerialization.toString(val), getCacheTime(methodsMapCache), methodsMapCache.optoins());
		}
	}


}
