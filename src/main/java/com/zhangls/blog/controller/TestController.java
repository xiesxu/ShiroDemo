package com.zhangls.blog.controller;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangls.blog.entity.User;
import com.zhangls.blog.service.UserService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/add")
	public String add(User loginUser,ServletRequest request){
		
		return "add";
	}
	
	@RequestMapping("/modify")
	public String modify(User loginUser,ServletRequest request){
		
		return "modify";
	}
	
	@RequestMapping("/delete")
	public String delete(User loginUser,ServletRequest request){
		
		return "delete";
	}
}
