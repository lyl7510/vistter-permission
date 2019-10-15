package com.base.vistter.system.controller;

import com.base.vistter.bean.Pager;
import com.base.vistter.bean.Result;
import com.base.vistter.exception.PlatformException;
import com.base.vistter.system.service.BaseModuleService;
import com.base.vistter.utils.SessionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/module")
public class BaseModuleController {

    private static final Logger logger = LogManager.getLogger(BaseModuleController.class);

    @Resource(name = "baseModuleServiceImpl")
    private BaseModuleService baseModuleService;

    @RequestMapping(value = "/findPager", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result findPager(HttpServletRequest request, @RequestBody Map paramMap){
        try {
            paramMap.put("PROJECT_CODE", SessionUtils.getProjectCode(request));
            Pager pager = baseModuleService.findPager(paramMap);
            return Result.generJson(pager);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result getUserList(HttpServletRequest request, @RequestBody Map paramMap){
        try {
            paramMap.put("BASE_ROLE_ID", SessionUtils.getRoleId(request));
            paramMap.put("PROJECT_CODE", SessionUtils.getProjectCode(request));
            List list = baseModuleService.getModuleListByRoleId(paramMap);
            return Result.generJson(list);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/getRoleList", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result getRoleList(HttpServletRequest request, @RequestBody Map paramMap){
        try {
            paramMap.put("PROJECT_CODE", SessionUtils.getProjectCode(request));
            List list = baseModuleService.getModuleListByRoleId(paramMap);
            return Result.generJson(list);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

  /*  @RequestMapping(value = "/moduleList", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result moduleList(HttpServletRequest request, @RequestBody Map paramMap){
        try {
            paramMap.put("PROJECT_CODE", SessionUtils.getProjectCode(request));
            List list = baseModuleService.findProjectModuleList(paramMap);
            return Result.generJson(list);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }*/

    @RequestMapping(value = "/load", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result load(@RequestBody Map paramMap){
        try {
            return Result.generJson(baseModuleService.load(MapUtils.getString(paramMap , "ID")));
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/getProjectModuleList", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result getProjectModuleList(HttpServletRequest request,@RequestBody Map paramMap){
        try {
            paramMap.put("PROJECT_CODE", SessionUtils.getProjectCode(request));
            return Result.generJson(baseModuleService.getProjectModuleList(paramMap));
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result save(HttpServletRequest request,@RequestBody Map paramMap){
        try {
            paramMap.put("PROJECT_CODE", SessionUtils.getProjectCode(request));
            baseModuleService.save(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody Map paramMap){
        try {
            baseModuleService.update(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.POST ,produces = "application/json;charset=UTF-8")
    public Result deleteById(@RequestBody Map paramMap){
        try {
            baseModuleService.deleteById(MapUtils.getString(paramMap, "ID"));
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result delete(@RequestBody Map paramMap){
        try {
            baseModuleService.delete((List) paramMap.get("list"));
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result start(@RequestBody Map paramMap){
        try {
            baseModuleService.start(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/stop", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result stop(@RequestBody Map paramMap){
        try {
            baseModuleService.stop(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }


}
