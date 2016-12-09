package com.ch.zn.wzl.demo.reids.cache.info;

import com.ch.zn.wzl.demo.reids.cache.serialization.Serialization;

public abstract class AbstractCacheProxyInfo implements ICacheProxyInfo {

	public abstract Object getKey();

	public abstract Object getVal();

	@Override
	public String toKeyString(Serialization serialization) {
		return serialization.toString(getKey());
	}

	@Override
	public <T> T toKeyObject(Serialization serialization, String string, Class<T> rsClass) {
		return serialization.toObject(string, rsClass);
	}

	@Override
	public String toValString(Serialization serialization) {
		return serialization.toString(getVal());
	}

	@Override
	public <T> T toValObject(Serialization serialization, String string, Class<T> rsClass) {
		return serialization.toObject(string, rsClass);
	}

}
