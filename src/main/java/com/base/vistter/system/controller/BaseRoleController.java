package com.base.vistter.system.controller;

import com.base.vistter.bean.Pager;
import com.base.vistter.bean.Result;
import com.base.vistter.exception.PlatformException;
import com.base.vistter.system.service.BaseRoleService;
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
@RequestMapping("/role")
public class BaseRoleController {

    private static final Logger logger = LogManager.getLogger(BaseRoleController.class);

    @Resource(name = "baseRoleServiceImpl")
    private BaseRoleService baseRoleService;

    @RequestMapping(value = "/findPager", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result findPager(HttpServletRequest request, @RequestBody Map paramMap) {
        try {
            paramMap.put("PROJECT_CODE", SessionUtils.getProjectCode(request));
            Pager pager = baseRoleService.findPager(paramMap);
            return Result.generJson(pager);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/findList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result findList(HttpServletRequest request, @RequestBody Map paramMap) {
        try {
            paramMap.put("PROJECT_CODE", SessionUtils.getProjectCode(request));
            List list = baseRoleService.findList(paramMap);
            return Result.generJson(list);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/load", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result load(@RequestBody Map paramMap) {
        try {
            return Result.generJson(baseRoleService.load(MapUtils.getString(paramMap, "ID")));
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result save(HttpServletRequest request, @RequestBody Map paramMap) {
        try {
            paramMap.put("PROJECT_CODE", SessionUtils.getProjectCode(request));
            baseRoleService.save(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody Map paramMap) {
        try {
            baseRoleService.update(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result deleteById(@RequestBody Map paramMap) {
        try {
            baseRoleService.deleteById(MapUtils.getString(paramMap, "ID"));
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result delete(@RequestBody Map paramMap) {
        try {
            baseRoleService.delete((List) paramMap.get("list"));
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result start(@RequestBody Map paramMap) {
        try {
            baseRoleService.start(MapUtils.getString(paramMap, "ID"));
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/stop", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result stop(@RequestBody Map paramMap) {
        try {
            baseRoleService.stop(MapUtils.getString(paramMap, "ID"));
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }
}
