package com.base.vistter.system.service;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.service.BaseService;

import java.util.List;
import java.util.Map;

public interface BaseDepartService extends BaseService {

    List findList(Map paramMap) throws PlatformException;

}
