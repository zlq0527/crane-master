package com.crane.system.controller;

import com.crane.system.entity.UserDO;
import com.crane.system.mapper.UserDAO;
import com.crane.system.service.LoginService;
import com.crane.system.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserDAO userDAO;

    @GetMapping("/loginJudge")
    public Object loginJudge(@RequestParam("userName") String userName, @RequestParam("password") String password) throws UnknownHostException, java.rmi.UnknownHostException {

        Map<String,Object> res=new HashMap<>();
        if(password!=""||userName!=""){
            UserDO userDO=loginService.findUser(userName);
            if(userDO!=null){
                if(password.equals(userDO.getPassword())){
                    if(userDO.getEnabled()){
                        String token=new JwtTokenUtil().generateToken(userDO);
                        res.put("code",100);
                        res.put("msg","登录成功");
                        res.put("token",token);
                        res.put("roleId",userDO.getRoleId());
                    }else{
                        res.put("code",400);
                        res.put("msg","用户已禁用");
                    }
                }else{
                    res.put("code",101);
                    res.put("msg","密码错误");
                }
            }else{
                res.put("code",200);
                res.put("msg","用户不存在");
            }
        }else{
            res.put("code",300);
            res.put("msg","用户或密码不能为空");
        }

        return res;
    }
    @GetMapping("/getUserName")
    public Map<String,Object> getUserName(HttpServletRequest request){
        Map<String,Object> res=new HashMap<>();
        String token = request.getHeader("token");
        JwtTokenUtil jwtTokenUtil=new JwtTokenUtil();
        String username=jwtTokenUtil.getUsernameFromToken(token);
        UserDO user=userDAO.findUser(username);
        res.put("relName",user.getRelName());
        return res;
    }
}
