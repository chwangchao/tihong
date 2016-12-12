package com.zh.cn.wzl.demo.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ch.zn.wzl.demo.reids.cache.annotations.MethodsMapCache;
import com.ch.zn.wzl.demo.reids.cache.strategy.impl.ListCacheStrategy;
import com.github.pagehelper.Page;
import com.zh.cn.wzl.demo.business.entity.ImUser;

@Service
public class CacheTestServiceImpl implements CacheTestService {

	@MethodsMapCache(cacheTime = 300)
	@Override
	public ImUser cacheTest_object() {
		System.out.println("CacheTestServiceImpl.cacheTest_object(0)");
		ImUser imUser = new ImUser();
		return imUser;
	}

	@MethodsMapCache(cacheTime = -1, key = "testKey")
	@Override
	public ImUser cacheTest_object(Object args) {
		System.out.println("CacheTestServiceImpl.cacheTest_object(1)");
		ImUser imUser = new ImUser();
		imUser.setUid(args.toString());
		return imUser;
	}

	@MethodsMapCache(targetArgs = { "0.uid" },cacheTime=-1)
	@Override
	public ImUser cacheTest_object(Object u, Object p) {
		System.out.println("CacheTestServiceImpl.cacheTest_object(2)");
		ImUser imUser = new ImUser();
		imUser.setImuid(u.toString());
		imUser.setImpwd(p.toString());
		return imUser;
	}

	@Override
	public ImUser cacheTest_object(Object args, Object args2, Object args3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List cacheTest_list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List cacheTest_list(Object args) {
		// TODO Auto-generated method stub
		return null;
	}

	@MethodsMapCache(key = "listKey", targetArgs = { "0.uid", "0.impwd",
			"1.uid" }, cacheTime = 1000, cacheStrategy = ListCacheStrategy.ListCacheStrategy, rsClass = ImUser.class)
	@Override
	public List cacheTest_list(Object u, Object p) {
		System.out.println("CacheTestServiceImpl.cacheTest_list(2)");
		List list = new ArrayList<>();
		list.add(u);
		list.add(p);
		return list;
	}

	@Override
	public List cacheTest_list(Object args, Object args2, Object args3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map cacheTest_map() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map cacheTest_map(Object args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map cacheTest_map(Object args, Object args2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map cacheTest_map(Object args, Object args2, Object args3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page cacheTest_wap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page cacheTest_wap(Object args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page cacheTest_wap(Object args, Object args2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page cacheTest_wap(Object args, Object args2, Object args3) {
		// TODO Auto-generated method stub
		return null;
	}

}
