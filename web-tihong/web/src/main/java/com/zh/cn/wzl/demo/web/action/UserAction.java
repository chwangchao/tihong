package com.zh.cn.wzl.demo.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zh.cn.wzl.demo.business.entity.ImUser;
import com.zh.cn.wzl.demo.business.service.UserService;

@RequestMapping("user")
@Controller
public class UserAction {

	@Autowired
	UserService userService;

	@RequestMapping("all.do")
	@ResponseBody
	public Object allUser() {
		List<ImUser> imUsers = userService.selectAll();
		return imUsers;
	}

	@RequestMapping("allpage.do")
	@ResponseBody
	public Object allUsersPage(int pageNum, int pageSize) {
		List<ImUser> imUsers = userService.selectPage(pageNum, pageSize);
		return imUsers;
	}

	@RequestMapping("page.html")
	public String page() {
		return "user/index";
	}
}
