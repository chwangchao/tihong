package com.ch.zn.wzl.demo.reids.cache.strategy;

import java.lang.reflect.Method;

import com.ch.zn.wzl.demo.reids.cache.annotations.MethodsMapCache;
import com.ch.zn.wzl.demo.reids.cache.serialization.Serialization;
import com.ch.zn.wzl.demo.reids.operation.helper.ProxyRedisCommand;

public abstract class AbstractMapCacheStrategy implements CacheStrategy {

	protected Serialization keySerialization;

	protected Serialization valSerialization;

	protected ProxyRedisCommand proxyRedisCommand;

	public Serialization getKeySerialization() {
		return keySerialization;
	}

	public void setKeySerialization(Serialization keySerialization) {
		this.keySerialization = keySerialization;
	}

	public Serialization getValSerialization() {
		return valSerialization;
	}

	public void setValSerialization(Serialization valSerialization) {
		this.valSerialization = valSerialization;
	}

	public ProxyRedisCommand getProxyRedisCommand() {
		return proxyRedisCommand;
	}

	public void setProxyRedisCommand(ProxyRedisCommand proxyRedisCommand) {
		this.proxyRedisCommand = proxyRedisCommand;
	}

	public String getkey(MethodsMapCache methodsMapCache) {
		String string = methodsMapCache.key();
		if ("".equals(string)) {
			return null;
		} else {
			return string;
		}
	}


	@Override
	public Object getCache(MethodsMapCache methodsMapCache, Object[] args,Method method) {
		Object[] objects = getTargetArgs(args, methodsMapCache.targetArgs(), methodsMapCache.optoins());
		String rootKey = getkey(methodsMapCache);
		String string;
		if (rootKey == null) {
			string = get(methodsMapCache.cacheDb(), keySerialization.toString(objects), methodsMapCache.optoins());
		} else {
			string = hget(methodsMapCache.cacheDb(), rootKey, keySerialization.toString(objects),
					methodsMapCache.optoins());
		}
		return valSerialization.toObject(string, method.getReturnType());
	}



	@Override
	public void cacheVal(MethodsMapCache methodsMapCache, Object[] args, Object val) {
		Object[] objects = getTargetArgs(args, methodsMapCache.targetArgs(), methodsMapCache.optoins());
		String rootKey = getkey(methodsMapCache);
		if (rootKey == null) {
			set(methodsMapCache.cacheDb(), keySerialization.toString(objects), valSerialization.toString(val),
					methodsMapCache.cacheTime(), methodsMapCache.optoins());
		} else {
			hset(methodsMapCache.cacheDb(), rootKey, keySerialization.toString(objects),
					valSerialization.toString(val), methodsMapCache.cacheTime(), methodsMapCache.optoins());
		}
	}

	public Object[] getTargetArgs(Object[] args, String[] target, String optoins){
		return args;
	}

	public abstract String get(int db, String key, String optoins);

	public abstract String hget(int db, String key, String field, String options);

	public abstract void set(int db, String key, String val, int time, String options);

	public abstract void hset(int db, String key, String field, String val, int time, String options);

	
}
