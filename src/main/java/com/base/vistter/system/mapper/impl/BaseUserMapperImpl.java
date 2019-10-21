package com.base.vistter.system.mapper.impl;

import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.common.mapper.impl.BaseMapperImpl;
import com.base.vistter.system.mapper.BaseUserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("baseUserMapperImpl")
public class BaseUserMapperImpl extends BaseMapperImpl implements BaseUserMapper {

    @Override
    protected String getNameSpace() {
        return "BaseUser";
    }

    public Map findByUserName(Map paramMap) throws PlatformException {
        try {
            return super.load("findByUserName", paramMap);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public void resetPwd(Map paramMap) throws PlatformException {
        try {
            super.update("resetPwd", paramMap);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public long countByRoleId(String roleId) throws PlatformException {
        try {
            return super.count("countByRoleId", roleId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public long countByRoleIds(List roleIds) throws PlatformException {
        try {
            return super.count("countByRoleIds", roleIds);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public long countByDepartId(String departId) throws PlatformException{
        try {
            return super.count("countByDepartId", departId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public long countByDepartIds(List departIds) throws PlatformException{
        try {
            return super.count("countByDepartIds", departIds);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public void start(Map paramMap) throws PlatformException{
        try {
            super.update("start", paramMap);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public void stop(Map paramMap) throws PlatformException{
        try {
            super.update("stop", paramMap);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public long usernameIsExit(Map paramMap) throws PlatformException{
        try {
            return super.count("usernameIsExit", paramMap);
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
