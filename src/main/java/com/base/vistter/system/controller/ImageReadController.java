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
public class ImageReadController {

    @Resource(name = "baseAttachmentServiceImpl")
    private BaseAttachmentService baseAttachmentService;

    @Value("${uploadPath}")
    private String savePath;

    @RequestMapping("/image")
    public void image(String id, HttpServletResponse response) {
        InputStream fis = null;
        OutputStream os = null;
        try {
            Map paramMap = baseAttachmentService.load(id);
            if(paramMap == null || paramMap.isEmpty()){
                return ;
            }
            File imageFile = new File(savePath + "/" + MapUtils.getString(paramMap , "FILE_PATH"));
            fis = new FileInputStream(imageFile);
            byte by[] = new byte[fis.available()];
            os = response.getOutputStream();
            int len = 0;
            while ((len = fis.read(by)) != -1) {
                os.write(by, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (PlatformException e){
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (os != null) {
                    os.flush();
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
