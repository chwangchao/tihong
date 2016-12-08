package com.zh.cn.wzl.demo.business.service;

import java.util.List;

import com.zh.cn.wzl.demo.business.entity.ImUser;

public interface UserService {

	List<ImUser> selectAll();

	List<ImUser> selectPage(int pageNum, int pageSize);

}
