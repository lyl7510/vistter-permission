package com.base.vistter.system.controller;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.system.service.BaseAttachmentService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

@Controller
public class DownloadController {

    @Resource(name = "baseAttachmentServiceImpl")
    private BaseAttachmentService baseAttachmentService;

    @Value("${uploadPath}")
    private String savePath;

    @RequestMapping("/download")
    public void downloadFile(String id ,HttpServletResponse response) throws PlatformException {
        Map paramMap = baseAttachmentService.load(id);
        if (paramMap == null || paramMap.isEmpty()) {
            return ;
        }
        //设置文件路径
        File file = new File(savePath + "/" + MapUtils.getString(paramMap , "FILE_PATH"));
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + MapUtils.getString(paramMap , "FILE_NAME"));// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
