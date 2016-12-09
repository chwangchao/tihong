package com.ch.zn.wzl.demo.reids.cache.serialization;

import java.util.List;

public interface Serialization {

	String toString(Object object);

	<T> T toObject(String string, Class<T> ts);

	<T> List<T> toList(String string, Class<T> ts);
}
