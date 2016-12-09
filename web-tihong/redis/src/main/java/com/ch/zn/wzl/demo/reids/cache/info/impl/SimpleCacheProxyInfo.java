package com.ch.zn.wzl.demo.reids.cache.info.impl;

import java.lang.reflect.Method;

import com.ch.zn.wzl.demo.reids.cache.info.abs.AbstractCacheProxyInfo;

public class SimpleCacheProxyInfo extends AbstractCacheProxyInfo {

	private String[] targetArgs;

	private Method targetMethod;

	private Object[] args;

	private String options;

	public String[] getTargetArgs() {
		return targetArgs;
	}

	public void setTargetArgs(String[] targetArgs) {
		this.targetArgs = targetArgs;
	}

	public Method getTargetMethod() {
		return targetMethod;
	}

	public void setTargetMethod(Method targetMethod) {
		this.targetMethod = targetMethod;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	@Override
	public Object getKey() {
		return this.getTargetArgs(targetArgs, targetMethod, args);
	}

	public SimpleCacheProxyInfo() {
	}

	public SimpleCacheProxyInfo(String[] targetArgs, Method targetMethod, Object[] args, String options) {
		this.targetArgs = targetArgs;
		this.targetMethod = targetMethod;
		this.args = args;
		this.options = options;
	}

}
