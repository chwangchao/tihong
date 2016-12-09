package com.ch.zn.wzl.demo.reids.cache.serialization;

import java.util.List;

/**
 * 
 * 主管缓存序列化
 *
 */
public interface Serialization {

	String toString(Object object);

	<T> T toObject(String string, Class<T> ts);

	<T> List<T> toList(String string, Class<T> ts);
}
