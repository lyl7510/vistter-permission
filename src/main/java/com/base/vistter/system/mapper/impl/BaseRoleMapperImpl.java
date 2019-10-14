package com.base.vistter.system.mapper.impl;

import com.base.vistter.mapper.impl.BaseMapperImpl;
import com.base.vistter.system.mapper.BaseRoleMapper;
import org.springframework.stereotype.Repository;

@Repository("baseRoleMapperImpl")
public class BaseRoleMapperImpl extends BaseMapperImpl implements BaseRoleMapper {

    @Override
    protected String getNameSpace() {
        return "BaseRole";
    }

}
