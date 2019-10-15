package com.base.vistter.system.controller;

import com.base.vistter.bean.Result;
import com.base.vistter.exception.PlatformException;
import com.base.vistter.system.service.BaseUserService;
import com.base.vistter.utils.Base64Utils;
import com.base.vistter.utils.SessionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class BaseUserController {

    private static final Logger logger = LogManager.getLogger(BaseModuleController.class);

    @Resource(name = "baseUserServiceImpl")
    private BaseUserService baseUserService;


    @RequestMapping(value = "/resetPwd", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result resetPwd(HttpServletRequest request, @RequestBody Map paramMap){
        try {
            paramMap.put("ID" , SessionUtils.getLoginUserId(request));
            paramMap.put("PASSWORD", Base64Utils.encode(MapUtils.getString(paramMap , "PASSWORD")));
            baseUserService.resetPwd(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }
}
