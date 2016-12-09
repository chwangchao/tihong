package com.ch.zn.wzl.demo.reids.cache.info.impl;

import java.lang.reflect.Method;

import com.ch.zn.wzl.demo.reids.cache.serialization.Serialization;

/**
 * list类型序列化
 *
 */
public class ListCacheProxyInfo extends SimpleCacheProxyInfo {

	private Class<?> cls;

	public Class<?> getCls() {
		return cls;
	}

	public void setCls(Class<?> cls) {
		this.cls = cls;
	}

	public ListCacheProxyInfo() {
		super();
	}

	public ListCacheProxyInfo(String[] targetArgs, Method targetMethod, Object[] args, Class<?> cls, String options) {
		super(targetArgs, targetMethod, args, options);
		this.cls = cls;
	}

	@Override
	public <T> Object toValObject(Serialization serialization, String string, Class<T> rsClass) {
		return serialization.toList(string, cls);
	}

}
