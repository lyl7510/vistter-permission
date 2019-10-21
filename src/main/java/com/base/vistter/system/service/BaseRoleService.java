package com.base.vistter.system.service;


import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.common.service.BaseService;

import java.util.List;
import java.util.Map;

public interface BaseRoleService extends BaseService {

    void start(Map paramMap) throws PlatformException;

    void stop(Map paramMap) throws PlatformException;

    List findList(Map paramMap) throws PlatformException;

}
