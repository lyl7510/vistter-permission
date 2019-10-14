package com.base.vistter.system.mapper;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.BaseMapper;

import java.util.Map;

public interface BaseProjectMapper extends BaseMapper {

    Map findProjectSettingByCode(String projectCode) throws PlatformException;

    long verifyProjectCode(String projectCode) throws PlatformException;
}
