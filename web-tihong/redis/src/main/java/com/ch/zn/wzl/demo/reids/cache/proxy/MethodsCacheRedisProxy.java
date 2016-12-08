package com.ch.zn.wzl.demo.reids.cache.proxy;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.ch.zn.wzl.demo.reids.cache.annotations.MethodsCache;

@Component
@Aspect
public class MethodsCacheRedisProxy {

	@Around("@annotation(com.ch.zn.wzl.demo.reids.cache.annotations.MethodsCache)")
	public Object proxyMethodCache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature joinPointObject = (MethodSignature) proceedingJoinPoint.getSignature();
		Method method = joinPointObject.getMethod();
		MethodsCache methodsCache = method.getAnnotation(MethodsCache.class);

		
		return null;
	}
}
