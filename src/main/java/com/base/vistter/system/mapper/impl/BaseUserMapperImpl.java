package com.base.vistter.system.mapper.impl;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.impl.BaseMapperImpl;
import com.base.vistter.system.mapper.BaseUserMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("baseUserMapperImpl")
public class BaseUserMapperImpl extends BaseMapperImpl implements BaseUserMapper {

    @Override
    protected String getNameSpace() {
        return "BaseUser";
    }

    public Map findByUserName(Map paramMap) throws PlatformException{
        try {
            return super.load("findByUserName" , paramMap);
        } catch (Exception var3) {
            logger.error(var3.getMessage());
            throw new PlatformException();
        }
    }
}
