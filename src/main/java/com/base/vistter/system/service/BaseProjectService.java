package com.base.vistter.system.service;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.service.BaseService;

import java.util.Map;

public interface BaseProjectService extends BaseService {

    /**
     *
     * @param projectCode
     * @return
     * @throws PlatformException
     */
    Map findProjectSettingByCode(String projectCode) throws PlatformException;


}
