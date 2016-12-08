package com.ch.zn.wzl.demo.reids.cache.proxy;

import java.lang.reflect.Method;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import com.ch.zn.wzl.demo.reids.cache.annotations.MethodsMapCache;
import com.ch.zn.wzl.demo.reids.cache.strategy.CacheStrategy;

@Aspect
public class MethodsMapCacheRedisProxy {

	private Map<String, CacheStrategy> cacheStrategyMap;

	public Map<String, CacheStrategy> getCacheStrategyMap() {
		return cacheStrategyMap;
	}

	public void setCacheStrategyMap(Map<String, CacheStrategy> cacheStrategyMap) {
		this.cacheStrategyMap = cacheStrategyMap;
	}

	@Around("@annotation(com.ch.zn.wzl.demo.reids.cache.annotations.MethodsMapCache)")
	public Object proxyMethodCache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature joinPointObject = (MethodSignature) proceedingJoinPoint.getSignature();
		Method method = joinPointObject.getMethod();
		MethodsMapCache methodsMapCache = method.getAnnotation(MethodsMapCache.class);
		String cacheStrategyString = methodsMapCache.cacheStrategy();
		CacheStrategy cacheStrategy = cacheStrategyMap.get(cacheStrategyString);
		Object[] args = proceedingJoinPoint.getArgs();
		Object val = cacheStrategy.getCache(methodsMapCache, args, method);
		if (val == null) {
			val = proceedingJoinPoint.proceed();
			cacheStrategy.cacheVal(methodsMapCache, args, val);
		}
		return val;
	}
}
