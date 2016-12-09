package com.ch.zn.wzl.demo.reids.cache.strategy.impl;

import java.lang.reflect.Method;

import com.ch.zn.wzl.demo.reids.cache.annotations.MethodsMapCache;
import com.ch.zn.wzl.demo.reids.cache.info.ICacheProxyInfo;
import com.ch.zn.wzl.demo.reids.cache.info.impl.ListCacheProxyInfo;
import com.ch.zn.wzl.demo.reids.cache.strategy.abs.AbstractDefaultCacheStrategy;

public class ListCacheStrategy extends AbstractDefaultCacheStrategy {

	public static final String ListCacheStrategy="ListCacheStrategy";
	
	@Override
	public String getStrategy() {
		return ListCacheStrategy;
	}

	@Override
	public ICacheProxyInfo initCacheProxyInfo(MethodsMapCache methodsMapCache, Object[] args, Method method) {
		ICacheProxyInfo iCacheProxyInfo = new ListCacheProxyInfo(methodsMapCache.targetArgs(), method, args,
				methodsMapCache.rsClass(), methodsMapCache.optoins());
		return iCacheProxyInfo;
	}

}
