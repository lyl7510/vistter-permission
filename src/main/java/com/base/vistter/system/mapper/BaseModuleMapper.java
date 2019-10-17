package com.base.vistter.system.mapper;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface BaseModuleMapper extends BaseMapper {

    List getModuleListByRoleId(Map paramMap) throws PlatformException;

    List getProjectModuleList(Map paramMap) throws PlatformException;

    void start(Map paramMap) throws PlatformException;

    void stop(Map paramMap) throws PlatformException;

    void deleteByProjectId(String projectId) throws PlatformException;

    void deleteByProjectIds(List projectIds) throws PlatformException;
}
