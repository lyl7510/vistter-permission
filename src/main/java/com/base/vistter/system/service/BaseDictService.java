package com.base.vistter.system.service;


import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.common.service.BaseService;

import java.util.List;
import java.util.Map;

public interface BaseDictService extends BaseService {

    List findList(Map paramMap) throws PlatformException;
}
