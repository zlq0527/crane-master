package com.crane.system.mapper;

import com.crane.system.entity.RoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleDAO {
    List<RoleDO> findAll();
    Integer insertRole(RoleDO roleDO);
    Integer deleteById(@Param("id") int id);
    RoleDO findRole(@Param("id") int id);
}
