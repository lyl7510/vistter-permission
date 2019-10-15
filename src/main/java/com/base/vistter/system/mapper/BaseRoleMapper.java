package com.base.vistter.system.mapper;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.BaseMapper;

import java.util.Map;

public interface BaseRoleMapper extends BaseMapper {

    void start(Map paramMap) throws PlatformException;

    void stop(Map paramMap) throws PlatformException;

}
