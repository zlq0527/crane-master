package com.crane.system.controller;

import com.crane.system.utils.AppResponse;
import com.crane.system.utils.FileUtil;
import com.crane.system.utils.ResponseCodeEnume;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author :zlq
 * @date : 2024/3/24
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @PostMapping("/upload")
    public AppResponse upload(MultipartFile file) {
        String uuid = FileUtil.uploadLocal(file);
        return new AppResponse(ResponseCodeEnume.SUCCESS.getCode(), "上传成功", uuid);
    }

    @GetMapping("/getImg/{uuid}")
    public void getImg(@PathVariable("uuid") String uuid, HttpServletResponse response) {
        FileUtil.downloadLocal(uuid, response);
    }
 }
