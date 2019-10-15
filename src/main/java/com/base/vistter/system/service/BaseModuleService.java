package com.base.vistter.system.service;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.service.BaseService;

import java.util.List;
import java.util.Map;

public interface BaseModuleService extends BaseService {

    List getModuleListByRoleId(Map paramMap) throws PlatformException;

    List getProjectModuleList(Map paramMap) throws PlatformException;

    void start(Map paramMap) throws PlatformException;

    void stop(Map paramMap) throws PlatformException;

    /*List findProjectModuleList(Map paramMap) throws PlatformException;*/
}
