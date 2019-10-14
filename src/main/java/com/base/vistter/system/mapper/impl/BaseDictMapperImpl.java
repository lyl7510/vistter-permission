package com.base.vistter.system.mapper.impl;

import com.base.vistter.mapper.impl.BaseMapperImpl;
import com.base.vistter.system.mapper.BaseDictMapper;
import org.springframework.stereotype.Repository;

@Repository("baseDictMapperImpl")
public class BaseDictMapperImpl extends BaseMapperImpl implements BaseDictMapper {

    @Override
    protected String getNameSpace() {
        return "BaseDict";
    }
}
