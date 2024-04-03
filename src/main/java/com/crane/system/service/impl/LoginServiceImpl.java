package com.crane.system.service.impl;

import com.crane.system.entity.UserDO;
import com.crane.system.mapper.UserDAO;
import com.crane.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public UserDO findUser(String userName) {
        UserDO userDO=userDAO.findUser(userName);
        return userDO;
    }
}
