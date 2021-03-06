package com.easymarket.controller;


import com.easymarket.entity.Response;
import com.easymarket.service.upload.UploadService;
import com.easymarket.utils.FileUtil;
import com.easymarket.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/api/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping(value = "/img")
    public Response imgUpload(@RequestParam("file")MultipartFile file) {
        String serverPath = uploadService.saveImg(file);
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("serverPath", serverPath);
        return ResponseUtil.success(res);
    }

}
