package com.base.vistter.system.mapper.impl;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.impl.BaseMapperImpl;
import com.base.vistter.system.mapper.BaseDictMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("baseDictMapperImpl")
public class BaseDictMapperImpl extends BaseMapperImpl implements BaseDictMapper {

    @Override
    protected String getNameSpace() {
        return "BaseDict";
    }

    public long isExist(Map paramMap) throws PlatformException{
        try {
            return super.count("isExist" , paramMap);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }
}
