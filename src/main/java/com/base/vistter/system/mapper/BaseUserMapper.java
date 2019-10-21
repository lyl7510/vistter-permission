package com.base.vistter.system.mapper;


import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.common.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface BaseUserMapper extends BaseMapper {

    Map findByUserName(Map paramMap) throws PlatformException;

    void resetPwd(Map paramMap) throws PlatformException;

    long countByRoleId(String roleId) throws PlatformException;

    long countByRoleIds(List roleIds) throws PlatformException;

    long countByDepartId(String departId) throws PlatformException;

    long countByDepartIds(List departIds) throws PlatformException;

    void start(Map paramMap) throws PlatformException;

    void stop(Map paramMap) throws PlatformException;

    long usernameIsExit(Map paramMap) throws PlatformException;

    void deleteByProjectId(String projectId) throws PlatformException;

    void deleteByProjectIds(List projectIds) throws PlatformException;


}
