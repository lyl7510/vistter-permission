package com.base.vistter.system.controller;

import com.base.vistter.common.bean.Pager;
import com.base.vistter.common.bean.Result;
import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.common.utils.SessionUtils;
import com.base.vistter.system.service.BaseDepartService;
import org.apache.commons.collections.MapUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/depart")
public class BaseDepartController{

    @Resource(name = "baseDepartServiceImpl")
    private BaseDepartService baseDepartService;

    protected static final Logger logger = LogManager.getLogger(BaseDepartController.class);

    @RequestMapping(value = "/findPager", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result findPager(HttpServletRequest request, @RequestBody Map paramMap){
        try {
            paramMap.put("PROJECT_CODE", SessionUtils.getProjectCode(request));
            Pager pager = baseDepartService.findPager(paramMap);
            return Result.generJson(pager);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/load", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result load(@RequestBody Map paramMap){
        try {
            return Result.generJson(baseDepartService.load(MapUtils.getString(paramMap , "ID")));
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result save(HttpServletRequest request,@RequestBody Map paramMap){
        try {
            paramMap.put("PROJECT_CODE", SessionUtils.getProjectCode(request));
            baseDepartService.save(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody Map paramMap){
        try {
            baseDepartService.update(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.POST ,produces = "application/json;charset=UTF-8")
    public Result deleteById(@RequestBody Map paramMap){
        try {
            baseDepartService.deleteById(MapUtils.getString(paramMap, "ID"));
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/findList", method = RequestMethod.POST ,produces = "application/json;charset=UTF-8")
    public Result findList(HttpServletRequest request){
        try {
            Map paramMap = new HashMap();
            paramMap.put("PROJECT_CODE", SessionUtils.getProjectCode(request));
            List list =  baseDepartService.findList(paramMap);
            return Result.generJson(list);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result delete(@RequestBody Map paramMap){
        try {
            baseDepartService.delete((List) paramMap.get("list"));
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }


}
