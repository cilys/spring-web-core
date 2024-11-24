package com.cilys.web.core.controller;

import com.cilys.web.core.utils.LogUtils;
import com.cilys.web.core.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

/**
 * Created by Administrator on 2024/11/22.
 */
@Controller
@RequestMapping("/file")
public class FileController extends BaseController {

    @PostMapping(value = "/upload")
    @ResponseBody
    public Map<String, Object> uploadFile(@RequestParam(value = "fileDir", defaultValue = "tmp") String fileDir
            , @RequestParam("fileUpload")MultipartFile file) {

        LogUtils.debug(logger, "开始上传文件..");
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUIDUtils.getUUID() + "_" + suffix;
//        File f = new File();


        return null;
    }
}
