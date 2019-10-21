package com.base.vistter.system.controller;

import com.base.vistter.common.bean.Pager;
import com.base.vistter.common.bean.Result;
import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.system.service.BaseProjectService;
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
@RequestMapping("/project")
public class BaseProjectController {

    private static final Logger logger = LogManager.getLogger(BaseProjectController.class);

    @Resource(name = "baseProjectServiceImpl")
    private BaseProjectService baseProjectService;

    @RequestMapping(value = "/findPager", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result findPager(@RequestBody Map paramMap){
        try {
            Pager pager = baseProjectService.findPager(paramMap);
            return Result.generJson(pager);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/load", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result load(@RequestBody Map paramMap){
        try {
            Map projectMap = baseProjectService.load(MapUtils.getString(paramMap , "ID"));
            return Result.generJson(projectMap);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result save(HttpServletRequest request, @RequestBody Map paramMap) {
        try {
            baseProjectService.save(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody Map paramMap) {
        try {
            baseProjectService.update(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result deleteById(@RequestBody Map paramMap) {
        try {
            baseProjectService.deleteById(MapUtils.getString(paramMap, "ID"));
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result delete(@RequestBody Map paramMap) {
        try {
            baseProjectService.delete((List) paramMap.get("list"));
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result start(@RequestBody Map paramMap) {
        try {
            baseProjectService.start(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }

    @RequestMapping(value = "/stop", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result stop(@RequestBody Map paramMap) {
        try {
            baseProjectService.stop(paramMap);
            return Result.generJson(null);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            return Result.generErrorJson(e.getCode());
        }
    }
}
