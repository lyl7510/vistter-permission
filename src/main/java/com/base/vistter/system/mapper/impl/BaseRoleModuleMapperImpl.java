package com.base.vistter.system.mapper.impl;

import com.base.vistter.mapper.impl.BaseMapperImpl;
import com.base.vistter.system.mapper.BaseRoleModuleMapper;
import org.springframework.stereotype.Repository;

@Repository("baseRoleModuleMapperImpl")
public class BaseRoleModuleMapperImpl extends BaseMapperImpl implements BaseRoleModuleMapper {

    @Override
    protected String getNameSpace() {
        return "BaseRoleModule";
    }
}
