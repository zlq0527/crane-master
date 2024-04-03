package com.crane.system.service;


import com.crane.system.entity.UserDO;

public interface LoginService {
    UserDO findUser(String userName);

}
