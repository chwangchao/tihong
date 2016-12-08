package com.zh.cn.wzl.demo.business.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;

public interface CacheTestService {
	<E> E cacheTest_object();

	<E> E cacheTest_object(Object args);

	<E> E cacheTest_object(Object args, Object args2);

	<E> E cacheTest_object(Object args, Object args2, Object args3);

	<E> List<E> cacheTest_list();

	<E> List<E> cacheTest_list(Object args);

	<E> List<E> cacheTest_list(Object args, Object args2);

	<E> List<E> cacheTest_list(Object args, Object args2, Object args3);

	<K, V> Map<K, V> cacheTest_map();

	<K, V> Map<K, V> cacheTest_map(Object args);

	<K, V> Map<K, V> cacheTest_map(Object args, Object args2);

	<K, V> Map<K, V> cacheTest_map(Object args, Object args2, Object args3);

	<E> Page<E> cacheTest_wap();

	<E> Page<E> cacheTest_wap(Object args);

	<E> Page<E> cacheTest_wap(Object args, Object args2);

	<E> Page<E> cacheTest_wap(Object args, Object args2, Object args3);

}
