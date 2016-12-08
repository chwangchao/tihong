package com.zh.cn.wzl.demo.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zh.cn.wzl.demo.business.dao.ImUserMapper;
import com.zh.cn.wzl.demo.business.entity.ImUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	ImUserMapper imUserMapper;

	@Override
	public List<ImUser> selectAll() {
		return imUserMapper.selectAll();
	}

	@Override
	public List<ImUser> selectPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return selectAll();
	}

}
