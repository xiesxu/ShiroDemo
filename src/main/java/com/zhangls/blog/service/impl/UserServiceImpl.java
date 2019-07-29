package com.zhangls.blog.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangls.blog.dao.UserDao;
import com.zhangls.blog.entity.User;
import com.zhangls.blog.service.UserService;
import com.zhangls.blog.utils.PasswordHelper;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired(required = false)
	private UserDao userDao;

	@Override
	public Long createUser(User user) {
		PasswordHelper.encryptPassword(user);
		return userDao.createUser(user);
	}

	@Override
	public void changePassword(Long userId, String newPassword) {
		User user = userDao.findOne(userId);
		user.setPassword(newPassword);
		userDao.updateUser(user);
	}

	@Override
	public void correlationRoles(Long userId, Long... roleIds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uncorrelationRoles(Long userId, Long... roleIds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public Set<String> findRoles(String username) {
		return userDao.findRoles(username);
	}

	@Override
	public Set<String> findPermissions(String username) {
		return userDao.findPermissions(username);
	}

}
