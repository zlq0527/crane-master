package com.crane.system.mapper;

import com.crane.system.entity.MenuDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface MenuDAO {
    List<MenuDO> findAll();
    MenuDO findById(@Param("id") int id);
}
