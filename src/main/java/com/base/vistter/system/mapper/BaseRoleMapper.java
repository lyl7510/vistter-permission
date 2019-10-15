package com.base.vistter.system.mapper;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.BaseMapper;

public interface BaseRoleMapper extends BaseMapper {

    void start(String id) throws PlatformException;

    void stop(String id) throws PlatformException;

}
