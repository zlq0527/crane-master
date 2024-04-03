package com.crane.system.mapper;

import com.crane.system.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserDAO {
    UserDO findUser(@Param("userName") String userName);
    List<UserDO> findAll();
    Integer updateEnabledAndRole(UserDO userDO);
    Integer addUser(UserDO userDO);
    List<UserDO> findComplex(@Param("userName") String userName,@Param("relName")String relName);

    int deleteById(@Param("id") int id);
}
