package com.zhangls.blog.dao;


import java.util.Set;

import com.zhangls.blog.entity.User;

public interface UserDao {
	
	/**
	 * 创建用户
	 * @param user
	 * @return
	 */
    public Long createUser(User user);
    /**
     * 修改用户
     * @param user
     */
    public void updateUser(User user);
    public void deleteUser(Long userId);

    User findOne(Long userId);

    User findByUsername(String username);
    
    /**
     * 获取用户角色
     * @param username
     * @return
     */
    Set<String> findRoles(String username);

    /**
     * 获取用户权限
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);
    
    public void correlationRoles(Long userId, Long... roleIds);
    public void uncorrelationRoles(Long userId, Long... roleIds);
}
