package com.crane.system.service;

import com.crane.system.entity.Menu;
import com.crane.system.entity.MenuDO;
import com.crane.system.entity.RoleDO;

import java.util.List;

public interface PermissionsService {
    List<Menu> getMenu(String userName);
    List<MenuDO> getBottomMenu(String userName);
    List<RoleDO> getRole();
    List<Integer> getCheckedKey(int roleId);
    Boolean updateRoleMenu(int roleId,List<Integer> menuIds);
    Boolean deleteRole(int roleId);
    Boolean addRole(RoleDO roleDO);

}
