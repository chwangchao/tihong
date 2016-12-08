package com.zh.cn.wzl.demo.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zh.cn.wzl.demo.business.entity.ImUser;

public interface ImUserMapper {
	// int deleteByPrimaryKey(Integer id);
	//
	// int insert(ImUser record);
	//
	// int insertSelective(ImUser record);
	//
	// ImUser selectByPrimaryKey(Integer id);
	//
	// int updateByPrimaryKeySelective(ImUser record);
	//
	// int updateByPrimaryKey(ImUser record);

	@Select("select * from im_user")
	List<ImUser> selectAll();

	@Select("SELECT * FROM im_user where uid=#{uid}")
	ImUser selectByName(String uid);
}