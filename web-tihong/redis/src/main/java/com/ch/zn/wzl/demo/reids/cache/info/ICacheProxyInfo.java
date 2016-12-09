package com.ch.zn.wzl.demo.reids.cache.info;

import com.ch.zn.wzl.demo.reids.cache.serialization.Serialization;

/**
 * 缓存代理信息 主管缓存序列化
 *
 */
public interface ICacheProxyInfo {

	String toKeyString(Serialization serialization);

	<T> Object toKeyObject(Serialization serialization, String string, Class<T> rsClass);

	String toValString(Serialization serialization,Object val);

	<T> Object toValObject(Serialization serialization, String string, Class<T> rsClass);
}
