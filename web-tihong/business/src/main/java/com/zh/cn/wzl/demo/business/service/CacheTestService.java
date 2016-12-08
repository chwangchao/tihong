package com.zh.cn.wzl.demo.business.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.zh.cn.wzl.demo.business.entity.ImUser;

public interface CacheTestService {
	
	ImUser cacheTest_object();

	ImUser cacheTest_object(Object args);

	ImUser cacheTest_object(Object args, Object args2);

	ImUser cacheTest_object(Object args, Object args2, Object args3);

	List cacheTest_list();

	List cacheTest_list(Object args);

	List cacheTest_list(Object args, Object args2);

	List cacheTest_list(Object args, Object args2, Object args3);

	Map cacheTest_map();

	Map cacheTest_map(Object args);

	Map cacheTest_map(Object args, Object args2);

	Map cacheTest_map(Object args, Object args2, Object args3);

	Page cacheTest_wap();

	Page cacheTest_wap(Object args);

	Page cacheTest_wap(Object args, Object args2);

	Page cacheTest_wap(Object args, Object args2, Object args3);

}
