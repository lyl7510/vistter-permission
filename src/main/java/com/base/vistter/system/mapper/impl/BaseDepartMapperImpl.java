package com.base.vistter.system.mapper.impl;

import com.base.vistter.mapper.impl.BaseMapperImpl;
import com.base.vistter.system.mapper.BaseDepartMapper;
import org.springframework.stereotype.Repository;

@Repository("baseDepartMapperImpl")
public class BaseDepartMapperImpl extends BaseMapperImpl implements BaseDepartMapper {

    protected String getNameSpace() {
        return "BaseDepart";
    }

}
