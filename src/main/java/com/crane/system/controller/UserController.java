package com.crane.system.controller;

import com.crane.system.entity.UserDO;
import com.crane.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //同时查询所有角色
    @GetMapping("/findAllUser")
    public Map<String,Object> findAllUser(@RequestParam int pageNum,@RequestParam int pageSize){
        return userService.findAll(pageNum,pageSize);
    }

    @PostMapping("/updateEnabled")
    public Boolean updateEnabled(@RequestBody UserDO userDO){
        return userService.updateEnabled(userDO);
    }

    @PostMapping("/updateRole")
    public Boolean updateRole(@RequestBody UserDO userDO){
        return userService.updateRole(userDO);
    }

    @PostMapping("/addUser")
    public Boolean addUser(@RequestBody UserDO userDO, HttpServletRequest request){
        return userService.addUser(userDO,request);
    }

    @GetMapping("/userFindComplex")
    public Map<String,Object> userFindComplex(@RequestParam int pageNum,@RequestParam int pageSize,@RequestParam String input1,@RequestParam String input2){
        return userService.findComplex(pageNum,pageSize,input1,input2);
    }

    @GetMapping("/deleteById/{id}")
    public Boolean deleteById(@PathVariable("id") int id) {
        return userService.deleteById(id);
    }
}
