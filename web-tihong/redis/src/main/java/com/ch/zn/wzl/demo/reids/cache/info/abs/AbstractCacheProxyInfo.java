package com.ch.zn.wzl.demo.reids.cache.info.abs;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.util.ReflectionUtils;

import com.ch.zn.wzl.demo.reids.cache.info.ICacheProxyInfo;
import com.ch.zn.wzl.demo.reids.cache.serialization.Serialization;

public abstract class AbstractCacheProxyInfo implements ICacheProxyInfo {

	public abstract Object getKey();

	public Object getVal(Object val) {
		return val;
	}

	@Override
	public String toKeyString(Serialization serialization) {
		return serialization.toString(getKey());
	}

	@Override
	public <T> Object toKeyObject(Serialization serialization, String string, Class<T> rsClass) {
		return serialization.toObject(string, rsClass);
	}

	@Override
	public String toValString(Serialization serialization, Object val) {
		return serialization.toString(getVal(val));
	}

	@Override
	public <T> Object toValObject(Serialization serialization, String string, Class<T> rsClass) {
		return serialization.toObject(string, rsClass);
	}

	public Object[] getTargetArgs(String[] target, Method method, Object[] args) {
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
