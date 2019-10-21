package com.base.vistter.system.controller;

import com.base.vistter.common.bean.Result;
import com.base.vistter.common.utils.SessionUtils;
import com.base.vistter.system.service.BaseRoleModuleService;
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
@RequestMapping("/roleModule")
public class BaseRoleModuleController {

    private static final Logger logger = LogManager.getLogger(BaseRoleModuleController.class);

    @Resource(name = "baseRoleModuleServiceImpl")
    private BaseRoleModuleService baseRoleModuleService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result save(HttpServletRequest request, @RequestBody Map paramMap) {
        try {
            paramMap.put("PROJECT_CODE", SessionUtils.getProjectCode(request));
            baseRoleModuleService.save(paramMap);
            return Result.generJson(null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/getListByRoleId", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result getListByRoleId(HttpServletRequest request, @RequestBody Map paramMap) {
        try {
            paramMap.put("PROJECT_CODE", SessionUtils.getProjectCode(request));
            List list = baseRoleModuleService.getListByRoleId(paramMap);
            return Result.generJson(list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
