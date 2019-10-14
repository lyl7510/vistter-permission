package com.base.vistter.system.controller;

import com.alibaba.druid.util.StringUtils;
import com.base.vistter.bean.Result;
import com.base.vistter.exception.PlatformException;
import com.base.vistter.system.service.BaseProjectService;
import com.base.vistter.system.service.BaseUserService;
import com.base.vistter.utils.Base64Utils;
import org.apache.commons.collections.MapUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class LoginController {

    private static final Logger logger = LogManager.getLogger(LoginController.class);

    @Resource(name = "baseProjectServiceImpl")
    private BaseProjectService baseProjectService;
    @Resource(name = "baseUserServiceImpl")
    private BaseUserService baseUserService;

    @PostMapping(value = "/isRequireCode" , produces = "application/json;charset=UTF-8")
    public Result isRequireCode(@RequestBody Map paramMap) throws PlatformException{
        Map projectMap = baseProjectService.findProjectSettingByCode(MapUtils.getString(paramMap , "projectCode"));
        if(projectMap == null){
            return Result.generErrorJson(151);
        }else{
            return Result.generJson(MapUtils.getIntValue(projectMap , "SECURITY_CODE"));
        }
    }

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public Result login(HttpServletRequest httpServletRequest , @RequestBody Map paramMap) throws PlatformException {

        String projectCode = MapUtils.getString(paramMap , "projectCode");
        String username = MapUtils.getString(paramMap , "username");
        String password = MapUtils.getString(paramMap , "password");
        String securityCode = MapUtils.getString(paramMap , "securityCode");

        //用戶名不能爲空
        if(StringUtils.isEmpty(username)){
            return  Result.generErrorJson(153);
        }

        //密碼不能爲空
        if(StringUtils.isEmpty(password)){
            return  Result.generErrorJson(157);
        }

        //项目不能为空
        Map projectMap = baseProjectService.findProjectSettingByCode(projectCode);
        if(null == projectMap){
            return  Result.generErrorJson(151);
        }

        if(1 == MapUtils.getIntValue(projectMap , "STATUS")){
            return  Result.generErrorJson(152);
        }

        if(1 == MapUtils.getIntValue(projectMap , "SECURITY_CODE")){
            //验证码不能为空
            if(StringUtils.isEmpty(securityCode)){
                return  Result.generErrorJson(159);
            }

            String sessionCode = String.valueOf(httpServletRequest.getSession().getAttribute("SecurityCode"));
            if(null == sessionCode || !sessionCode.equals(securityCode)){
                return  Result.generErrorJson(160);
            }
        }
        paramMap.put("TELPHONE_LOGIN" , MapUtils.getIntValue(projectMap , "TELPHONE_LOGIN"));
        //找不到登录用户
        Map userMap = baseUserService.findByUserName(paramMap);
        if(null == userMap){
            return  Result.generErrorJson(154);
        }

        //用户已停用
        if(1 == MapUtils.getIntValue(userMap , "STATUS")){
            return  Result.generErrorJson(156);
        }

        //密码不正确
        if(!MapUtils.getString(userMap , "PASSWORD").equals(Base64Utils.encode(password))){
            return  Result.generErrorJson(158);
        }
        return Result.generJson(userMap);
    }
}
