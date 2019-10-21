package com.base.vistter.system.mapper.impl;

import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.common.mapper.impl.BaseMapperImpl;
import com.base.vistter.system.mapper.BaseRoleModuleMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("baseRoleModuleMapperImpl")
public class BaseRoleModuleMapperImpl extends BaseMapperImpl implements BaseRoleModuleMapper {

    @Override
    protected String getNameSpace() {
        return "BaseRoleModule";
    }

    @Override
    public void deleteByModuleId(String moduleId) throws PlatformException {
        try {
            super.delete("deleteByModuleId", moduleId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public void deleteByModuleIds(List moduleIds) throws PlatformException {
        try {
            super.delete("deleteByModuleIds", moduleIds);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public void deleteByRoleId(String roleId) throws PlatformException {
        try {
            super.delete("deleteByRoleId", roleId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public void deleteByRoleIds(List roleIds) throws PlatformException {
        try {
            super.delete("deleteByRoleIds", roleIds);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public void deleteByProjectRoleId(Map paramMap) throws PlatformException {
        try {
            super.delete("deleteByProjectRoleId", paramMap);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public void save(Map paramMap) throws PlatformException {
        try {
            super.save(paramMap);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public List getListByRoleId(Map paramMap) throws PlatformException {
        try {
            return super.findList("getListByRoleId", paramMap);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public void deleteByProjectId(String projectId) throws PlatformException{
        try {
            super.delete("deleteByProjectId" , projectId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public void deleteByProjectIds(List projectIds) throws PlatformException{
        try {
            super.delete("deleteByProjectIds" , projectIds);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }
}
