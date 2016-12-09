package com.ch.zn.wzl.demo.reids.cache.serialization.impl;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.ch.zn.wzl.demo.reids.cache.serialization.Serialization;

public class FastJsonSerialization implements Serialization {

	@Override
	public String toString(Object object) {
		return JSON.toJSONString(object);
	}

	@Override
	public <T> T toObject(String string, Class<T> ts) {
		return JSON.parseObject(string, ts);
	}

	@Override
	public <T> List<T> toList(String string, Class<T> ts) {
		return JSON.parseArray(string, ts);
	}

}
