package com.zhangls.blog.dao;

import com.zhangls.blog.entity.Permission;


public interface PermissionDao {

    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);

}
