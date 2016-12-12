package com.ch.zn.wzl.demo.reids.cache.proxy;

import java.lang.reflect.Method;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import com.ch.zn.wzl.demo.reids.cache.annotations.MethodsMapCache;
import com.ch.zn.wzl.demo.reids.cache.strategy.CacheStrategy;

/**
 * 
 * 缓存代理aop切面
 */
@Aspect
public class MethodsMapCacheRedisProxy {

	/**
	 * 注册的策略
	 */
	private Map<String, CacheStrategy> cacheStrategyMap;

	public Map<String, CacheStrategy> getCacheStrategyMap() {
		return cacheStrategyMap;
	}

	public void setCacheStrategyMap(Map<String, CacheStrategy> cacheStrategyMap) {
		this.cacheStrategyMap = cacheStrategyMap;
	}

	//环绕方法
	@Around("@annotation(com.ch.zn.wzl.demo.reids.cache.annotations.MethodsMapCache)")
	public Object proxyMethodCache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature joinPointObject = (MethodSignature) proceedingJoinPoint.getSignature();
		Method method = joinPointObject.getMethod();
		//读目标方法上的注解
		MethodsMapCache methodsMapCache = method.getAnnotation(MethodsMapCache.class);
		//读注解上配置的策略字符串
		String cacheStrategyString = methodsMapCache.cacheStrategy();
		//根据字符串读策略
		CacheStrategy cacheStrategy = cacheStrategyMap.get(cacheStrategyString);
		//目标方法参数
		Object[] args = proceedingJoinPoint.getArgs();
		//根据缓存策略读取缓存
		Object val = cacheStrategy.getCache(methodsMapCache, args, method);
		if (val == null) {
			//缓存值为null 则执行目标方法
			val = proceedingJoinPoint.proceed();
			//根据缓存策略缓存值
			cacheStrategy.cacheVal(methodsMapCache,method, args, val);
		}
		return val;
	}
}
