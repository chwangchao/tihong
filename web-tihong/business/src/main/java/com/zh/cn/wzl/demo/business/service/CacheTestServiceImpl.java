package com.zh.cn.wzl.demo.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ch.zn.wzl.demo.reids.cache.annotations.MethodsMapCache;
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

	@MethodsMapCache(cacheTime = 300, key = "testKey")
	@Override
	public ImUser cacheTest_object(Object args) {
		System.out.println("CacheTestServiceImpl.cacheTest_object(1)");
		ImUser imUser = new ImUser();
		imUser.setUid(args.toString());
		return imUser;
	}

	@MethodsMapCache(cacheTime = 300, targetArgs = { "args" })
	@Override
	public ImUser cacheTest_object(Object args, Object args2) {
		System.out.println("CacheTestServiceImpl.cacheTest_object(2)");
		ImUser imUser = new ImUser();
		imUser.setImuid(args.toString());
		imUser.setImpwd(args.toString());
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

	@Override
	public List cacheTest_list(Object args, Object args2) {
		// TODO Auto-generated method stub
		return null;
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
