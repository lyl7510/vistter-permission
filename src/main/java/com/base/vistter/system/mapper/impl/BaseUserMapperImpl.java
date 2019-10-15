package com.base.vistter.system.mapper.impl;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.impl.BaseMapperImpl;
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

}
