package com.base.vistter.system.mapper;


import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.common.mapper.BaseMapper;

import java.util.Map;

public interface BaseProjectMapper extends BaseMapper {

    Map findProjectSettingByCode(String projectCode) throws PlatformException;

    long verifyProjectCode(String projectCode) throws PlatformException;

    void start(Map paramMap) throws PlatformException;

    void stop(Map paramMap) throws PlatformException;
}
