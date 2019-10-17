package com.base.vistter.system.controller;

import com.base.vistter.bean.Pager;
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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class BaseUserController {

    private static final Logger logger = LogManager.getLogger(BaseUserController.class);

    @Resource(name = "baseUserServiceImpl")
    private BaseUserService baseUserService;

    @RequestMapping(value = "/findPager", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result findPager(HttpServletRequest request, @RequestBody Map paramMap){
        try {
            paramMap.put("PROJECT_CODE", SessionUtils.getProjectCode(request));
            Pager pager = baseUserService.findPager(paramMap);
            return Result.generJson(pager);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

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

    @RequestMapping(value = "/load", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result load(@RequestBody Map paramMap){
        try {
            return Result.generJson(baseUserService.load(MapUtils.getString(paramMap , "ID")));
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result save(HttpServletRequest request,@RequestBody Map paramMap){
        try {
            paramMap.put("PROJECT_CODE", SessionUtils.getProjectCode(request));
            baseUserService.save(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody Map paramMap){
        try {
            baseUserService.update(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.POST ,produces = "application/json;charset=UTF-8")
    public Result deleteById(@RequestBody Map paramMap){
        try {
            baseUserService.deleteById(MapUtils.getString(paramMap, "ID"));
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result delete(@RequestBody Map paramMap){
        try {
            baseUserService.delete((List) paramMap.get("list"));
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result start(@RequestBody Map paramMap){
        try {
            baseUserService.start(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/stop", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result stop(@RequestBody Map paramMap){
        try {
            baseUserService.stop(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }
}
