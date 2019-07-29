package com.zhangls.blog.service;

import com.zhangls.blog.entity.Permission;



public interface PermissionService {
	
	public Permission createPermission(Permission permission);
	
	public void deletePermission(Long permissionId);
}
