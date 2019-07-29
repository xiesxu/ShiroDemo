package com.zhangls.blog.controller;

import javax.servlet.ServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zhangls.blog.entity.User;
import com.zhangls.blog.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/·")
	public ModelAndView login(User loginUser,ServletRequest request){
		
		ModelAndView view = new ModelAndView();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(loginUser.getUsername(),loginUser.getPassword());
		if(!subject.isAuthenticated()){
			
			subject.login(token);
		}
		
		SavedRequest savedRequest = WebUtils.getSavedRequest(request);
		String url = "";
		if(savedRequest != null){
			url = savedRequest.getRequestUrl();
		}else{
			url = "/page/main.html";
		}
		
		view.setViewName("redirect:"+url);
		return view;
	}
	
	@RequestMapping("/register")
	public ModelAndView add(User user){
		ModelAndView view = new ModelAndView();
		userService.createUser(user);
		view.setViewName("redirect:/login.html");
		return view;
	}
	
	@RequestMapping("/logout")
	public String logout(User loginUser){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "已注销";
	}
}
