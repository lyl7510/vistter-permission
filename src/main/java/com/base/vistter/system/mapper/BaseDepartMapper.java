package com.base.vistter.system.mapper;

import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.common.mapper.BaseMapper;

import java.util.List;


public interface BaseDepartMapper extends BaseMapper {

    void deleteByProjectId(String projectId) throws PlatformException;

    void deleteByProjectIds(List projectIds) throws PlatformException;
}
