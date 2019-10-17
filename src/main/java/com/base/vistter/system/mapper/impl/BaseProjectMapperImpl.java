package com.base.vistter.system.mapper.impl;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.impl.BaseMapperImpl;
import com.base.vistter.system.mapper.BaseProjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("baseProjectMapperImpl")
public class BaseProjectMapperImpl extends BaseMapperImpl implements BaseProjectMapper {

    @Override
    protected String getNameSpace() {
        return "BaseProject";
    }

    public Map findProjectSettingByCode(String projectCode) throws PlatformException{
        try {
            return super.load("findProjectSettingByCode" , projectCode);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public long verifyProjectCode(String projectCode) throws PlatformException {
        try {
            return super.count("verifyProjectCode" , projectCode);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public void start(Map paramMap) throws PlatformException{
        try {
            super.update("start" ,paramMap);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public void stop(Map paramMap) throws PlatformException{
        try {
            super.update("stop" ,paramMap);
        } catch (PlatformException e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }
}
