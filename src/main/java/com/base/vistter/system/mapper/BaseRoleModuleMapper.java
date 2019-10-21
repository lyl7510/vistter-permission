package com.base.vistter.system.mapper;


import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.common.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface BaseRoleModuleMapper extends BaseMapper {

    void deleteByModuleId(String moduleId) throws PlatformException;

    void deleteByModuleIds(List moduleIds) throws PlatformException;

    void deleteByRoleId(String roleId) throws PlatformException;

    void deleteByRoleIds(List roleIds) throws PlatformException;

    void deleteByProjectRoleId(Map paramMap) throws PlatformException;

    void save(Map paramMap) throws PlatformException;

    List getListByRoleId(Map paramMap) throws PlatformException;

    void deleteByProjectId(String projectId) throws PlatformException;

    void deleteByProjectIds(List projectIds) throws PlatformException;
}
