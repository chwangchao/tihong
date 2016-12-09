package com.ch.zn.wzl.demo.reids.cache.strategy.abs;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.util.ReflectionUtils;

import com.ch.zn.wzl.demo.reids.cache.annotations.MethodsMapCache;
import com.ch.zn.wzl.demo.reids.cache.serialization.Serialization;
import com.ch.zn.wzl.demo.reids.cache.strategy.CacheStrategy;
import com.ch.zn.wzl.demo.reids.operation.helper.ProxyRedisCommand;

public abstract class AbstractCacheStrategy implements CacheStrategy {

	protected int defaultCacheTime;

	protected int defaultCacheDb;

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

	public int getDefaultCacheTime() {
		return defaultCacheTime;
	}

	public void setDefaultCacheTime(int defaultCacheTime) {
		this.defaultCacheTime = defaultCacheTime;
	}

	public int getDefaultCacheDb() {
		return defaultCacheDb;
	}

	public void setDefaultCacheDb(int defaultCacheDb) {
		this.defaultCacheDb = defaultCacheDb;
	}

	public int getCacheDb(MethodsMapCache methodsMapCache) {
		int i = methodsMapCache.cacheDb();
		return i == 0 ? defaultCacheDb : i;
	}

	public int getCacheTime(MethodsMapCache methodsMapCache) {
		int i = methodsMapCache.cacheTime();
		return i == 0 ? defaultCacheTime : i;
	}

	public String getkey(MethodsMapCache methodsMapCache) {
		String string = methodsMapCache.key();
		if ("".equals(string)) {
			return null;
		} else {
			return string;
		}
	}

	public ProxyRedisCommand getProxyRedisCommand() {
		return proxyRedisCommand;
	}

	public void setProxyRedisCommand(ProxyRedisCommand proxyRedisCommand) {
		this.proxyRedisCommand = proxyRedisCommand;
	}

	public String get(int db, String key, String optoins) {
		return proxyRedisCommand.get(db, key);
	}

	public String hget(int db, String key, String field, String options) {
		return proxyRedisCommand.hget(db, key, field);
	}

	public void set(int db, String key, String val, int time, String options) {
		proxyRedisCommand.set(db, key, val);
		proxyRedisCommand.expire(db, key, time);
	}

	public void hset(int db, String key, String field, String val, int time, String options) {
		proxyRedisCommand.hset(db, key, field, val);
		proxyRedisCommand.expire(db, key, time);
	}

	public Object[] getTargetArgs(MethodsMapCache methodsMapCache, Method method, Object[] args) {
		String[] target = methodsMapCache.targetArgs();
		if (target.length == 0) {
			return args;
		}
		List<Object> list = new ArrayList<>();
		String[] temp;
		Object tempO;
		for (String string : target) {
			temp = string.split("\\.");
			tempO = args;
			for (int i = 0; i < temp.length; i++) {
				tempO = getTragetArgs(tempO, temp[i]);
			}
			list.add(tempO);
		}

		return list.toArray();
	}

	private Object getTragetArgs(Object object, String field) {

		if (field == null) {
			return object;
		} else if (object instanceof Map) {
			Map temp = (Map) object;
			return temp.get(field);
		} else if (object instanceof List) {
			List temp = (List) object;
			return temp.get(Integer.parseInt(field));
		} else if (object instanceof Object[]) {
			Object[] temp = (Object[]) object;
			return temp[Integer.parseInt(field)];
		} else {
			Field field2 = ReflectionUtils.findField(object.getClass(), field);
			field2.setAccessible(true);
			return ReflectionUtils.getField(field2, object);
		}
	}

}
