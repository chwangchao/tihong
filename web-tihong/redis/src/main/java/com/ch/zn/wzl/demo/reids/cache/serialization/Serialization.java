package com.ch.zn.wzl.demo.reids.cache.serialization;

public interface Serialization {

	String toString(Object object);
	
	
	<T> T toObject(String string,Class<T> ts);
}
