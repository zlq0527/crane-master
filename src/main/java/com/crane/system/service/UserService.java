package com.crane.system.service;


import com.crane.system.entity.UserDO;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserService {
    Map<String,Object> findAll(int pageNum,int pageSize);
    Boolean updateEnabled(UserDO userDO);
    Boolean updateRole(UserDO userDO);
    Boolean addUser(UserDO userDO, HttpServletRequest request);
    Map<String,Object> findComplex(int pageNum,int pageSize,String userName,String relName);

    Boolean deleteById(int  id);
}
