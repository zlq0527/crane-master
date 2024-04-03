package com.crane.system.mapper;

import com.crane.system.model.MenuRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuRoleDAO {
    List<MenuRole> findByRoleId(@Param("roleId") int roleId);
    Integer insertMenuRole(MenuRole menuRole);
    Integer deleteByRoleId(@Param("roleId") int roleId);

}
