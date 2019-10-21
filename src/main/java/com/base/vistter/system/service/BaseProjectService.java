package com.base.vistter.system.service;


import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.common.service.BaseService;

import java.util.Map;

public interface BaseProjectService extends BaseService {

    /**
     *
     * @param projectCode
     * @return
     * @throws PlatformException
     */
    Map findProjectSettingByCode(String projectCode) throws PlatformException;

    /**
     *
     * @param paramMap
     * @throws PlatformException
     */
    void start(Map paramMap) throws PlatformException;

    void stop(Map paramMap) throws PlatformException;
}
