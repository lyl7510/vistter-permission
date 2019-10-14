package com.base.vistter.system.controller;

import com.base.vistter.bean.Pager;
import com.base.vistter.bean.Result;
import com.base.vistter.exception.PlatformException;
import com.base.vistter.system.service.BaseProjectService;
import org.apache.commons.collections.MapUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/project")
public class BaseProjectController {

    private static final Logger logger = LogManager.getLogger(BaseProjectController.class);

    @Resource(name = "baseProjectServiceImpl")
    private BaseProjectService baseProjectService;

    @RequestMapping(value = "/findPager", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
    public Result findPager(@RequestBody Pager pager){
        try {
            pager = baseProjectService.findPager(pager);
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

}
