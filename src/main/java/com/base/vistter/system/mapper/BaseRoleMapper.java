package com.base.vistter.system.mapper;


import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.common.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface BaseRoleMapper extends BaseMapper {

    void start(Map paramMap) throws PlatformException;

    void stop(Map paramMap) throws PlatformException;

    void deleteByProjectId(String projectId) throws PlatformException;

    void deleteByProjectIds(List projectIds) throws PlatformException;
}
