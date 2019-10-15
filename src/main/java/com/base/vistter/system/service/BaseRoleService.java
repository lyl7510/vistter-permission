package com.base.vistter.system.service;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.service.BaseService;

import java.util.List;
import java.util.Map;

public interface BaseRoleService extends BaseService {

    void start(String id) throws PlatformException;

    void stop(String id) throws PlatformException;

    List findList(Map paramMap) throws PlatformException;

}
