package com.base.vistter.system.mapper.impl;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.impl.BaseMapperImpl;
import com.base.vistter.system.mapper.BaseModuleMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("baseModuleMapperImpl")
public class BaseModuleMapperImpl extends BaseMapperImpl implements BaseModuleMapper {

    protected String getNameSpace() {
        return "BaseModule";
    }

    public List getModuleListByRoleId(Map paramMap) throws PlatformException {
        try {
            return super.findList("getModuleListByRoleId", paramMap);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public List getProjectModuleList(Map paramMap) throws PlatformException{
        try {
            return super.findList("getProjectModuleList", paramMap);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public void start(String id) throws PlatformException{
        try {
            super.update("start", id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public void stop(String id) throws PlatformException{
        try {
            super.update("stop", id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }
}
