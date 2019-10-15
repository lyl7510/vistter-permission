package com.base.vistter.system.service;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.service.BaseService;

import java.util.Map;

public interface BaseRoleModuleService extends BaseService {

    void save(Map paramMap) throws PlatformException;
}
