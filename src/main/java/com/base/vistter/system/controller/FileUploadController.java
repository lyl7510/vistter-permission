package com.base.vistter.system.controller;

import com.base.vistter.bean.Result;
import com.base.vistter.exception.PlatformException;
import com.base.vistter.system.service.BaseAttachmentService;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.core.util.UuidUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.annotation.Resource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
public class FileUploadController {

    @Resource(name = "baseAttachmentServiceImpl")
    private BaseAttachmentService baseAttachmentService;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    @Value("${uploadPath}")
    private String savePath;

    @RequestMapping("/upload")
    public Result upload(StandardMultipartHttpServletRequest request) {
        Map<String, MultipartFile> fileMap = request.getFileMap();

        for (String fileName : fileMap.keySet()) {
            MultipartFile multipartFile = fileMap.get(fileName);
            // 创建保存数据库对象
            Map paramMap = new HashMap();
            paramMap.put("FILE_NAME", multipartFile.getOriginalFilename());
            paramMap.put("FILE_TYPE", multipartFile.getContentType());

            String newFilePath = dateFormat.format(new Date()) + "/" + System.currentTimeMillis() + getExtension(multipartFile.getOriginalFilename());
            // log.info("上传文件路径:{}",newFilePath);
            paramMap.put("FILE_PATH", newFilePath);
            paramMap.put("FILE_SIZE", multipartFile.getSize());
            paramMap.put("ID" , UuidUtil.getTimeBasedUuid());

            // 文件在服务器上保存一份
            try {
                copyFile(multipartFile, newFilePath);
                baseAttachmentService.save(paramMap);
            } catch (IOException e) {
                return Result.generErrorJson(999);
            }catch (PlatformException e){
                return Result.generErrorJson(e.getCode());
            }

            return Result.generJson(paramMap);
        }
        return Result.generErrorJson(999);
    }

    private void copyFile(MultipartFile multipartFile, String newFilePath)
            throws IOException {
        File newFile = new File(savePath + "/" + newFilePath);
        File parentFile = newFile.getParentFile();

        if (parentFile != null) {
            parentFile.mkdirs();
        }
        if (!newFile.exists()) {
            newFile.createNewFile();
        }
        byte[] bytes = multipartFile.getBytes();
        BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(newFile));
        buffStream.write(bytes);
        buffStream.close();

    }

    private String getExtension(String fileName) {
        if (!StringUtils.isEmpty(fileName)) {
            return fileName.substring(fileName.lastIndexOf("."));
        } else {
            return "";
        }
    }

    @PostMapping(value = "/getFile" , produces = "application/json;charset=UTF-8")
    public Result getFile(@RequestBody Map paramMap){
        try {
            Map map = baseAttachmentService.load(MapUtils.getString(paramMap , "ID"));
            return Result.generJson(map);
        } catch (PlatformException e){
            return Result.generErrorJson(e.getCode());
        }

    }

}
