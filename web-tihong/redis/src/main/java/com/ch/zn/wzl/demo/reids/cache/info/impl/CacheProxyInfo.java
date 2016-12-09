package com.ch.zn.wzl.demo.reids.cache.info.impl;

import java.lang.reflect.Method;

import com.ch.zn.wzl.demo.reids.cache.info.AbstractCacheProxyInfo;
import com.ch.zn.wzl.demo.reids.cache.strategy.CacheStrategy;

public class CacheProxyInfo extends AbstractCacheProxyInfo {

	private String key;

	private String[] targetArgs;

	private CacheStrategy cacheStrategy;

	private int cacheTime;

	private int cacheDb;

	private String optoins;

	private Method targetMethod;

	@Override
	public Object getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getVal() {
		// TODO Auto-generated method stub
		return null;
	}

}
